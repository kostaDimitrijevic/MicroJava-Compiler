// generated with ast extension for cup
// version 0.8
// 5/7/2022 17:8:23


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationList extends Declaration {

    private Declaration Declaration;
    private ClassDecList ClassDecList;

    public ClassDeclarationList (Declaration Declaration, ClassDecList ClassDecList) {
        this.Declaration=Declaration;
        if(Declaration!=null) Declaration.setParent(this);
        this.ClassDecList=ClassDecList;
        if(ClassDecList!=null) ClassDecList.setParent(this);
    }

    public Declaration getDeclaration() {
        return Declaration;
    }

    public void setDeclaration(Declaration Declaration) {
        this.Declaration=Declaration;
    }

    public ClassDecList getClassDecList() {
        return ClassDecList;
    }

    public void setClassDecList(ClassDecList ClassDecList) {
        this.ClassDecList=ClassDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declaration!=null) Declaration.accept(visitor);
        if(ClassDecList!=null) ClassDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declaration!=null) Declaration.traverseTopDown(visitor);
        if(ClassDecList!=null) ClassDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declaration!=null) Declaration.traverseBottomUp(visitor);
        if(ClassDecList!=null) ClassDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationList(\n");

        if(Declaration!=null)
            buffer.append(Declaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDecList!=null)
            buffer.append(ClassDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationList]");
        return buffer.toString();
    }
}
