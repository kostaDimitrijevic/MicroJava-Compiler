// generated with ast extension for cup
// version 0.8
// 7/7/2022 17:2:57


package rs.ac.bg.etf.pp1.ast;

public class Inc extends Operations {

    public Inc () {
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
        buffer.append("Inc(\n");

        buffer.append(tab);
        buffer.append(") [Inc]");
        return buffer.toString();
    }
}
