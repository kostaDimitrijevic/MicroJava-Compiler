// generated with ast extension for cup
// version 0.8
// 28/5/2022 0:4:42


package rs.ac.bg.etf.pp1.ast;

public class Exponent extends Expop {

    public Exponent () {
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
        buffer.append("Exponent(\n");

        buffer.append(tab);
        buffer.append(") [Exponent]");
        return buffer.toString();
    }
}
