package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
	private int mainPc;
	private Struct boolType = new Struct(Struct.Bool);
	
	public int getMainPc() {
		return mainPc;
	}

	public void visit(PrintStatement pr) {
		if(pr.getExpr().struct == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else if(pr.getExpr().struct == boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(NumberConst numCon) {
		Obj con = Tab.insert(Obj.Con, "#const", Tab.intType);
		con.setLevel(0);
		con.setAdr(numCon.getVal());		
		Code.load(con);
	}
	
	public void visit(CharacterConst chrCon) {
		Obj con = Tab.insert(Obj.Con, "const", Tab.charType);
		con.setLevel(0);
		con.setAdr(Integer.parseInt(chrCon.getVal()));	
	}
	
	public void visit(BooleanConst boolCon) {
		Obj con = Tab.insert(Obj.Con, "const", boolType);
		con.setLevel(0);
		if(boolCon.getVal().equals("true")) {
			con.setAdr(1);
		}
		else {
			con.setAdr(0);
		}
	}
	
	public void visit(MethodTypeName meth) {
		if("main".equalsIgnoreCase(meth.getMethodName())) {
			mainPc = Code.pc;
		}
		
		meth.obj.setAdr(Code.pc);
		
		Code.put(Code.enter);
		Code.put(0);
		Code.put(0 + meth.obj.getLocalSymbols().size());
	}
	
	public void visit(Method methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
}
