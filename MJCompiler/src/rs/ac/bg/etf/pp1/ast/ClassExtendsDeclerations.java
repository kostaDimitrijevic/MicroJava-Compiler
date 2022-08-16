// generated with ast extension for cup
// version 0.8
// 15/7/2022 22:42:26


package rs.ac.bg.etf.pp1.ast;

public class ClassExtendsDeclerations extends ClassDecList {

    private String className;
    private Type Type;
    private OptionalVarDecList OptionalVarDecList;
    private MethodPart MethodPart;

    public ClassExtendsDeclerations (String className, Type Type, OptionalVarDecList OptionalVarDecList, MethodPart MethodPart) {
        this.className=className;
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptionalVarDecList=OptionalVarDecList;
        if(OptionalVarDecList!=null) OptionalVarDecList.setParent(this);
        this.MethodPart=MethodPart;
        if(MethodPart!=null) MethodPart.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public OptionalVarDecList getOptionalVarDecList() {
        return OptionalVarDecList;
    }

    public void setOptionalVarDecList(OptionalVarDecList OptionalVarDecList) {
        this.OptionalVarDecList=OptionalVarDecList;
    }

    public MethodPart getMethodPart() {
        return MethodPart;
    }

    public void setMethodPart(MethodPart MethodPart) {
        this.MethodPart=MethodPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.accept(visitor);
        if(MethodPart!=null) MethodPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseTopDown(visitor);
        if(MethodPart!=null) MethodPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseBottomUp(visitor);
        if(MethodPart!=null) MethodPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassExtendsDeclerations(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalVarDecList!=null)
            buffer.append(OptionalVarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodPart!=null)
            buffer.append(MethodPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassExtendsDeclerations]");
        return buffer.toString();
    }
}
