// generated with ast extension for cup
// version 0.8
// 12/7/2022 17:49:35


package rs.ac.bg.etf.pp1.ast;

public class LowerEqual extends Relop {

    public LowerEqual () {
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
        buffer.append("LowerEqual(\n");

        buffer.append(tab);
        buffer.append(") [LowerEqual]");
        return buffer.toString();
    }
}
