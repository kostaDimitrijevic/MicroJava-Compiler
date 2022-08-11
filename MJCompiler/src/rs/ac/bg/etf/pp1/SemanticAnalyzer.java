package rs.ac.bg.etf.pp1;

import java.util.Stack;

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
	private Obj currentDesig = null;
	private int currentLvl = 0;
	
	private Stack<Obj> stack = new Stack<Obj>();
	
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
		if(v == Tab.noObj) {
			var.obj = Tab.insert(Obj.Var, var.getVarName(), currentType);
			if(currentMethod != null) {
				report_info("Deklarisana lokalna promenljiva " + var.getVarName() + " metode " + currentMethod.getName(), var);
			}
			else {
				report_info("Deklarisana promenljiva "+ var.getVarName(), var);
			}
		}
		else {
			report_error("Greska! Deklarisana promenljiva "+ var.getVarName() + " vec postoji!", var);
		}
	}
	
	public void visit(VarArray varArr) {
		Obj v = Tab.find(varArr.getVarName());
		if(v == Tab.noObj) {
			varArr.obj = Tab.insert(Obj.Var, varArr.getVarName(), currentType);
			if(currentMethod != null) {
				report_info("Deklarisana lokalni niz "+ varArr.getVarName() + " metode " + currentMethod.getName(), varArr);
			}
			else {
				report_info("Deklarisana niz "+ varArr.getVarName(), varArr);
			}
		}
		else {
			report_error("Greska! Deklarisana niz "+ varArr.getVarName() + " vec postoji!", varArr);
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
	
	public void visit(VoidType voidmethod) {
		voidmethod.struct = Tab.noType;
	}
	
	public void visit(NumConstant numConst) {
		Obj c = Tab.find(numConst.getVarName());
		if(c == Tab.noObj) {
			if(currentType.equals(Tab.intType)) {
				Obj con = Tab.insert(Obj.Con, numConst.getVarName(), Tab.intType);
				con.setAdr(numConst.getVal());
				report_info("Definicija constante " + numConst.getVarName(), numConst);
			}
			else {
				report_error("Greska! Los tip konstante", numConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + numConst.getVarName() + " je vec definisana", numConst);
		}
	}

	public void visit(CharConstant charConst) {
		Obj c = Tab.find(charConst.getVarName());
		if(c == Tab.noObj) {
			if(currentType.equals(Tab.charType)) {
				Obj con = Tab.insert(Obj.Con, charConst.getVarName(), Tab.charType);
				con.setAdr(Integer.parseInt(charConst.getVal()));
				charConst.obj = con;
				report_info("Definicija constante " + charConst.getVarName(), charConst);
			}
			else {
				report_error("Greska! Los tip konstante", charConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + charConst.getVarName() + " je vec definisana", charConst);
		}
	}

	public void visit(BoolConstant boolConst) {
		Obj c = Tab.find(boolConst.getVarName());
		if(c == Tab.noObj) {
			if(currentType.equals(boolType) && (boolConst.getVal().equals("true") || boolConst.getVal().equals("false"))) {
				boolConst.obj = Tab.insert(Obj.Con, boolConst.getVarName(), boolType);
				if(boolConst.getVal().equals("true")) {
					boolConst.obj.setAdr(1);
				}
				else {
					boolConst.obj.setAdr(0);
				}
				report_info("Definicija constante " + boolConst.getVarName(), boolConst);
			}
			else {
				report_error("Greska! Los tip konstante", boolConst);
			}
		}
		else {
			report_error("Greska! Konstanta " + boolConst.getVarName() + " je vec definisana", boolConst);
		}
	}
	
	public void visit(MethodTypeName method) {
		if(method.getMethodName().equals("main") && method.getType().struct.getKind() != Struct.None) {
			report_error("metoda main mora da bude tipa void!", method);
			method.obj = Tab.noObj;
		}
		else {
			currentMethod = Tab.insert(Obj.Meth, method.getMethodName(), method.getType().struct);
			method.obj = currentMethod;
			method.obj.setLevel(0);
			Tab.openScope();
		}
		
		report_info("Obradjuje se funkcija " + method.getMethodName(), method);
	}
	
	public void visit(Method methodDecl) {
		if(currentMethod != null) {
			Tab.chainLocalSymbols(currentMethod);
			Tab.closeScope();
		}
		
		currentMethod = null;
	}
	
	public void visit(SingleDesig desig) {
		Obj d = Tab.find(desig.getName());
		if(d == Tab.noObj || (d.getKind() != Obj.Con && d.getKind() != Obj.Var)) {
			desig.obj = Tab.noObj;
			report_error("Greska na liniji " + desig.getLine() + " : ime " + desig.getName() + " nije deklarisano! ",
					null);
		}
		else {
			String message = d.getLevel() > 0 ? "koriscen lokalni simbol: " : "koriscen globalni simbol: ";
			report_info(message + d.getName(), desig);
		}
		
		desig.obj = d;
	}
	
	public void visit(DesigList list) {
		list.obj = list.getDesignatorName().obj;
	}
	
	public void visit(DesigName des) {
		Obj d = Tab.find(des.getName());
		if(d == Tab.noObj || (d.getKind() != Obj.Var && d.getKind() != Obj.Con)) {
			report_error("Greska na liniji " + des.getLine() + " : ime " + des.getName() + " nije deklarisano! ",
					null);
			d = Tab.noObj;
		}
		else {
			currentDesig = d;
		}
		
		String message = d.getLevel() > 0 ? "koriscen lokalni simbol: " : "koriscen globalni simbol: ";
		report_info(message + d.getName(), des);
		
		stack.push(currentDesig);
		des.obj = d;
	}
	
	public void visit(FieldBox fieldArr) {
		if(fieldArr.getExpr().struct.getKind() == Struct.Int) {
			Obj o = stack.pop();
			stack.push(new Obj(Obj.Var, o.getName(), o.getType()));
		}
		else {
			report_error("Index niza mora biti tipa int", fieldArr);
		}
	}
	
	public void visit(VarDesig var) {
		if(var.getDesignator() instanceof DesigList) {
			Obj d = stack.pop();
			if(d != null) {
				var.struct = d.getType();
			}
		}
		else {
			Obj d = var.getDesignator().obj;
			if(d != null) {
				var.struct = d.getType();
			}
		}
	}
	
	public void visit(Terms mulop) {
		Struct t = mulop.getTerm().struct;
		Struct f = mulop.getFactor().struct;
		if(t == Tab.intType && f == Tab.intType) {
			mulop.struct = Tab.intType;
		}
		else {
			report_error("Greska na liniji " + mulop.getLine() + " : nekompatibilni tipovi u izrazu racunske operacije.",
					null);
			mulop.struct = Tab.noType;
		}
	}
	
	public void visit(ListFactor coal) {
		Struct f1 = coal.getFactor().struct;
		Struct f2 = coal.getBaseExp().struct;
		if(f1 == Tab.intType && f2 == Tab.intType) {
			coal.struct = Tab.intType;
		}
		else {
			report_error("Greska na liniji " + coal.getLine() + " : nekompatibilni tipovi u izrazu coalesce operacije.",
					null);
			coal.struct = Tab.noType;
		}
	}
	
	public void visit(AddExpr addOp) {
		Struct ex = addOp.getExpression().struct;
		Struct term = addOp.getTerm().struct;
		if (ex.compatibleWith(term) && ex == Tab.intType) {
			addOp.struct = Tab.intType;
		} else {
			report_error("Greska na liniji " + addOp.getLine() + " : nekompatibilni tipovi u izrazu za sabiranje.",
					null);
			addOp.struct = Tab.noType;
		}
	}
	
	public void visit(AssignOperation assign) {
		assign.struct = assign.getExpr().struct;
	}
	
	public void visit(Inc incOp) {
		incOp.struct = Tab.intType;
	}
	
	public void visit(Dec decOp) {
		decOp.struct = Tab.intType;
	}
	
	public void visit(NumberConst num) {
		num.struct = Tab.intType;
	}
	
	public void visit(CharacterConst ch) {
		ch.struct = Tab.charType;
	}
	
	public void visit(BooleanConst bl) {
		bl.struct = boolType;
	}
	
	public void visit(SingleTerm term) {
		term.struct = term.getFactor().struct;
	}
	
	public void visit(SingleFactor fact) {
		fact.struct = fact.getBaseExp().struct;
	}
	
	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}
	
	public void visit(Express expr) {
		expr.struct = expr.getExpression().struct;
	}
	
	public void visit(MinusExpress expr) {
		expr.struct = expr.getExpression().struct;
	}
	
	public void visit(PrintStatement pr) {
		Struct ex = pr.getExpr().struct;
		if(ex != Tab.intType && ex != Tab.charType && ex != boolType) {
			report_error("Greska na liniji " + pr.getLine() + " : "
					+ "nekompatibilni tip promenljive u pozivu print funkcije! ", null);
		}
	}
	
	public void visit(ReadStatement read) {
		Obj d = Tab.find(read.getDesignator().obj.getName());
		if(d != Tab.noObj) {
			Struct st = d.getType();
			if(st != Tab.intType && st != Tab.charType && st != boolType) {
				report_error("Greska na liniji " + read.getLine() + " : "
						+ "nekompatibilni tip promenljive u pozivu read funkcije! ", null);
			}
		}
		else {
			report_error("Greska na liniji " + read.getLine() + " : "
					+ "funkciji read mora da se proslediti promenljiva ili niz! ", null);
		}
	}
	
	public void visit(DesignatorStatementOp op) {
		if(op.getDesignator() instanceof SingleDesig) {
			Obj d = op.getDesignator().obj;
			if(op.getOperations().struct != Tab.noType) {
				if (!op.getOperations().struct.assignableTo(d.getType())) {
					report_error("Greska na liniji " + op.getLine() + " : "
							+ "nekompatibilni tipovi u dodeli vrednosti! ", null);
				}
			}
			else {
				report_error(
						"Greska na liniji " + op.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ",
						null);
			}
		}
		else {
			Obj d = stack.pop();
			if(op.getOperations().struct != Tab.noType) {
				if(!op.getOperations().struct.assignableTo(d.getType())) {
					report_error("Greska na liniji " + op.getLine() + " : "
							+ "nekompatibilni tipovi u dodeli vrednosti! ", null);
				}
			}
			else {
				report_error(
						"Greska na liniji " + op.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ",
						null);
			}
		}
	}
	
	public void visit(NewExpr newArr) {
		if(newArr.getExpr().struct.getKind() != Struct.Int) {
			report_error("Index niza mora biti tipa int", newArr);
			newArr.struct = Tab.noType;
		}
		else {
			newArr.struct = newArr.getType().struct;
		}
	}
}
