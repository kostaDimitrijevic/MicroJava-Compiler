// generated with ast extension for cup
// version 0.8
// 28/5/2022 0:4:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationList extends Declaration {

    private Declaration Declaration;
    private ConstDecList ConstDecList;

    public ConstDeclarationList (Declaration Declaration, ConstDecList ConstDecList) {
        this.Declaration=Declaration;
        if(Declaration!=null) Declaration.setParent(this);
        this.ConstDecList=ConstDecList;
        if(ConstDecList!=null) ConstDecList.setParent(this);
    }

    public Declaration getDeclaration() {
        return Declaration;
    }

    public void setDeclaration(Declaration Declaration) {
        this.Declaration=Declaration;
    }

    public ConstDecList getConstDecList() {
        return ConstDecList;
    }

    public void setConstDecList(ConstDecList ConstDecList) {
        this.ConstDecList=ConstDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declaration!=null) Declaration.accept(visitor);
        if(ConstDecList!=null) ConstDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declaration!=null) Declaration.traverseTopDown(visitor);
        if(ConstDecList!=null) ConstDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declaration!=null) Declaration.traverseBottomUp(visitor);
        if(ConstDecList!=null) ConstDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationList(\n");

        if(Declaration!=null)
            buffer.append(Declaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecList!=null)
            buffer.append(ConstDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationList]");
        return buffer.toString();
    }
}
