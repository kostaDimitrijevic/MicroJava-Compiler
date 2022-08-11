// generated with ast extension for cup
// version 0.8
// 11/7/2022 22:45:31


package rs.ac.bg.etf.pp1.ast;

public class Fields extends FieldList {

    private FieldList FieldList;
    private Field Field;

    public Fields (FieldList FieldList, Field Field) {
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
        this.Field=Field;
        if(Field!=null) Field.setParent(this);
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public Field getField() {
        return Field;
    }

    public void setField(Field Field) {
        this.Field=Field;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldList!=null) FieldList.accept(visitor);
        if(Field!=null) Field.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
        if(Field!=null) Field.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        if(Field!=null) Field.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Fields(\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Field!=null)
            buffer.append(Field.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Fields]");
        return buffer.toString();
    }
}
