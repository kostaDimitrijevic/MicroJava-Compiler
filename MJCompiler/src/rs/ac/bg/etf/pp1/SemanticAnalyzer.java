package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor{
	private boolean returnFound = false;
	public boolean errorDetected = false;
	
	private Struct boolType = new Struct(Struct.Bool);
	private Struct currentType = null;
	private Logger log = Logger.getLogger(getClass());
	
	public int nVars = 0;
	
	private Obj currentMethod = null;
	private int currentLvl = 0;
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.insert(Obj.Type, "bool", boolType);
		Tab.openScope();
	}
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(VarNoArray var) {
		Obj v = Tab.find(var.getVarName());
		if(v == null) {
			var.obj = Tab.insert(Obj.Var, var.getVarName(), currentType);
			report_info("Deklarisana promenljiva "+ var.getVarName(), var);
		}
		else {
			report_error("Greska! Deklarisana promenljiva "+ var.getVarName() + "vec postoji!", var);
		}
	}
	
	public void visit(VarArray varArr) {
		Obj v = Tab.find(varArr.getVarName());
		if(v == null) {
			varArr.obj = Tab.insert(Obj.Var, varArr.getVarName(), currentType);
			report_info("Deklarisana niz "+ varArr.getVarName(), varArr);
		}
		else {
			report_error("Greska! Deklarisana niz "+ varArr.getVarName() + "vec postoji!", varArr);
		}
	}
	
	public void visit(IdentType type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
			}
			currentType = type.struct;
		}
	}
	
	public void visit(NumConstant numConst) {
		Obj c = Tab.find(numConst.getVarName());
		if(c == null) {
			if(currentType.equals(Tab.intType)) {
				Obj con = Tab.insert(Obj.Con, numConst.getVarName(), Tab.intType);
				con.setAdr(numConst.getVal());
				report_info("Definicija constante" + numConst.getVarName(), numConst);
			}
			else {
				report_error("Greska! Los tip konstante", numConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + numConst.getVarName() + "je vec definisana", numConst);
		}
	}

	public void visit(CharConstant charConst) {
		Obj c = Tab.find(charConst.getVarName());
		if(c == null) {
			if(currentType.equals(Tab.charType)) {
				Obj con = Tab.insert(Obj.Con, charConst.getVarName(), Tab.charType);
				con.setAdr(Integer.parseInt(charConst.getVal()));
				charConst.obj = con;
				report_info("Definicija constante" + charConst.getVarName(), charConst);
			}
			else {
				report_error("Greska! Los tip konstante", charConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + charConst.getVarName() + "je vec definisana", charConst);
		}
	}

	public void visit(BoolConstant boolConst) {
		Obj c = Tab.find(boolConst.getVarName());
		if(c == null) {
			if(currentType.equals(boolType)) {
				boolConst.obj = Tab.insert(Obj.Con, boolConst.getVarName(), boolType);
				report_info("Definicija constante" + boolConst.getVarName(), boolConst);
			}
			else {
				report_error("Greska! Los tip konstante", boolConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + boolConst.getVarName() + "je vec definisana", boolConst);
		}
	}
}
