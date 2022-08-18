package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
	private int mainPc;
	private Struct boolType = new Struct(Struct.Bool);
	
	private boolean printLen = false;
	private boolean readVisited = false;
	
	public int getMainPc() {
		return mainPc;
	}

	public void visit(PrintStatement pr) {
		if(!printLen) {
			Code.loadConst(5);
		}
		printLen = false;
		if(pr.getExpr().struct.getKind() == Struct.Array) {
			if(pr.getExpr().struct.getElemType() == Tab.intType || pr.getExpr().struct.getElemType() == boolType) {
				Code.put(Code.print);
			}
			else {
				Code.put(Code.bprint);
			}
		}
		else {
			if(pr.getExpr().struct == Tab.intType || pr.getExpr().struct == boolType) {
				Code.put(Code.print);
			}
			else {
				Code.put(Code.bprint);
			}
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
		con.setAdr(chrCon.getVal());	
		Code.load(con);
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
		Code.load(con);
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
	
	public void visit(DesignatorStatementOp op) {
		if(op.getDesignator().getClass().equals(DesigList.class)) {
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			if(op.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.bastore);
			}
			else {
				Code.put(Code.astore);
			}
		}
		else {
			Code.store(op.getDesignator().obj);
		}


	}
	
	public void visit(VarDesig des) {
		if(des.getDesignator().getClass().equals(DesigList.class)) {
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			if(des.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.baload);
			}
			else {
				Code.put(Code.aload);
			}
		}
	}
	
	public void visit(SingleDesig des) {
		Code.load(des.obj);
	}
	
	public void visit(DesigList desArr) {
		Code.load(desArr.obj);
	}
	
	public void visit(Prints prints) {
		Obj con = Tab.insert(Obj.Con, "#len", Tab.intType);
		con.setLevel(0);
		con.setAdr(prints.getVal());
		printLen = true;
		Code.load(con);
	}
	
	public void visit(AddExpr addOp) {
		if(addOp.getAddop().getClass().equals(Minus.class)){
			Code.put(Code.sub);
		}
		else {
			Code.put(Code.add);
		}		
	}
	
	public void visit(ListFactor mulOp) {
		if(mulOp.getMulop().getClass().equals(Mul.class)) {
			Code.put(Code.mul);
		}
		else if(mulOp.getMulop().getClass().equals(Div.class)){
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
	
	public void visit(Inc inc) {
		Code.loadConst(1);
		Code.put(Code.add);
	}
	
	public void visit(Dec dec) {
		Code.loadConst(1);
		Code.put(Code.sub);
	}
	
	public void visit(Terms coal) {
		Obj val = Tab.insert(Obj.Var, "#val", Tab.intType);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.dup);
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, Code.pc + 9);
		Code.store(val);
		Code.put(Code.pop);
		Code.load(val);
		Code.putJump(Code.pc + 4);
		Code.put(Code.pop);
	}
	
	public void visit(NewExpr newArr) {
		Code.put(Code.newarray);
		if(newArr.struct.getElemType() == Tab.intType) {
			Code.put(1);
		}
		else {
			Code.put(0);
		}
	}
	
	public void visit(ReadStatement read) {
		readVisited = true;
		if(read.getDesignator().getClass().equals(DesigList.class)) {
			if(read.getDesignator().obj.getType().getElemType() == Tab.intType) {
				Code.put(Code.read);
			}
			else if(read.getDesignator().obj.getType().getElemType() == Tab.charType){
				Code.put(Code.bread);
			}
			
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.put(Code.dup_x2);
			Code.put(Code.pop);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			if(read.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.bastore);
			}
			else {
				Code.put(Code.astore);
			}
			
		}
		else {
			if(read.getDesignator().obj.getType() == Tab.intType) {
				Code.put(Code.read);
			}
			else {
				Code.put(Code.bread);
			}
			
			Code.store(read.getDesignator().obj);
		}
	}
}
