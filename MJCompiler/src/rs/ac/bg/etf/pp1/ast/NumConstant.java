// generated with ast extension for cup
// version 0.8
// 18/7/2022 12:23:36


package rs.ac.bg.etf.pp1.ast;

public class NumConstant extends Const {

    private String varName;
    private Integer val;

    public NumConstant (String varName, Integer val) {
        this.varName=varName;
        this.val=val;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val=val;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumConstant(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(" "+tab+val);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConstant]");
        return buffer.toString();
    }
}
