// generated with ast extension for cup
// version 0.8
// 11/7/2022 22:45:31


package rs.ac.bg.etf.pp1.ast;

public class IdentType extends Type {

    private String typeName;

    public IdentType (String typeName) {
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName=typeName;
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
        buffer.append("IdentType(\n");

        buffer.append(" "+tab+typeName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentType]");
        return buffer.toString();
    }
}
