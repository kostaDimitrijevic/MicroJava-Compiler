// generated with ast extension for cup
// version 0.8
// 12/7/2022 17:49:35


package rs.ac.bg.etf.pp1.ast;

public class FieldNoBox extends Field {

    private String fieldName;

    public FieldNoBox (String fieldName) {
        this.fieldName=fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName=fieldName;
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
        buffer.append("FieldNoBox(\n");

        buffer.append(" "+tab+fieldName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldNoBox]");
        return buffer.toString();
    }
}
