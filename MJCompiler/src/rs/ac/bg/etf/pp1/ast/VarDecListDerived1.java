// generated with ast extension for cup
// version 0.8
// 11/7/2022 22:45:31


package rs.ac.bg.etf.pp1.ast;

public class VarDecListDerived1 extends VarDecList {

    public VarDecListDerived1 () {
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
        buffer.append("VarDecListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [VarDecListDerived1]");
        return buffer.toString();
    }
}
