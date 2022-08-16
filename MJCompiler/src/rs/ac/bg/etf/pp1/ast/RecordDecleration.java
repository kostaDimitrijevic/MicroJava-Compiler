// generated with ast extension for cup
// version 0.8
// 15/7/2022 22:42:26


package rs.ac.bg.etf.pp1.ast;

public class RecordDecleration extends RecordDecList {

    private RecordName RecordName;
    private OptionalVarDecList OptionalVarDecList;

    public RecordDecleration (RecordName RecordName, OptionalVarDecList OptionalVarDecList) {
        this.RecordName=RecordName;
        if(RecordName!=null) RecordName.setParent(this);
        this.OptionalVarDecList=OptionalVarDecList;
        if(OptionalVarDecList!=null) OptionalVarDecList.setParent(this);
    }

    public RecordName getRecordName() {
        return RecordName;
    }

    public void setRecordName(RecordName RecordName) {
        this.RecordName=RecordName;
    }

    public OptionalVarDecList getOptionalVarDecList() {
        return OptionalVarDecList;
    }

    public void setOptionalVarDecList(OptionalVarDecList OptionalVarDecList) {
        this.OptionalVarDecList=OptionalVarDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RecordName!=null) RecordName.accept(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RecordName!=null) RecordName.traverseTopDown(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RecordName!=null) RecordName.traverseBottomUp(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDecleration(\n");

        if(RecordName!=null)
            buffer.append(RecordName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalVarDecList!=null)
            buffer.append(OptionalVarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDecleration]");
        return buffer.toString();
    }
}
