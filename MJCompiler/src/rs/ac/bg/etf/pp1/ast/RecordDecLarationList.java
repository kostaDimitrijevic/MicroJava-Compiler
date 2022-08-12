// generated with ast extension for cup
// version 0.8
// 12/7/2022 17:49:35


package rs.ac.bg.etf.pp1.ast;

public class RecordDecLarationList extends Declaration {

    private Declaration Declaration;
    private RecordDecList RecordDecList;

    public RecordDecLarationList (Declaration Declaration, RecordDecList RecordDecList) {
        this.Declaration=Declaration;
        if(Declaration!=null) Declaration.setParent(this);
        this.RecordDecList=RecordDecList;
        if(RecordDecList!=null) RecordDecList.setParent(this);
    }

    public Declaration getDeclaration() {
        return Declaration;
    }

    public void setDeclaration(Declaration Declaration) {
        this.Declaration=Declaration;
    }

    public RecordDecList getRecordDecList() {
        return RecordDecList;
    }

    public void setRecordDecList(RecordDecList RecordDecList) {
        this.RecordDecList=RecordDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declaration!=null) Declaration.accept(visitor);
        if(RecordDecList!=null) RecordDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declaration!=null) Declaration.traverseTopDown(visitor);
        if(RecordDecList!=null) RecordDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declaration!=null) Declaration.traverseBottomUp(visitor);
        if(RecordDecList!=null) RecordDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDecLarationList(\n");

        if(Declaration!=null)
            buffer.append(Declaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecordDecList!=null)
            buffer.append(RecordDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDecLarationList]");
        return buffer.toString();
    }
}
