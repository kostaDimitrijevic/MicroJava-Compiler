// generated with ast extension for cup
// version 0.8
// 11/7/2022 22:45:31


package rs.ac.bg.etf.pp1.ast;

public class DesigList extends Designator {

    private DesignatorName DesignatorName;
    private FieldList FieldList;

    public DesigList (DesignatorName DesignatorName, FieldList FieldList) {
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
    }

    public DesignatorName getDesignatorName() {
        return DesignatorName;
    }

    public void setDesignatorName(DesignatorName DesignatorName) {
        this.DesignatorName=DesignatorName;
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.accept(visitor);
        if(FieldList!=null) FieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigList(\n");

        if(DesignatorName!=null)
            buffer.append(DesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigList]");
        return buffer.toString();
    }
}
