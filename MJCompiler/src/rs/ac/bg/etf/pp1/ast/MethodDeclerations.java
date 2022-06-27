// generated with ast extension for cup
// version 0.8
// 28/5/2022 0:4:42


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclerations extends MethodDecList {

    private MethodDecList MethodDecList;
    private Method Method;

    public MethodDeclerations (MethodDecList MethodDecList, Method Method) {
        this.MethodDecList=MethodDecList;
        if(MethodDecList!=null) MethodDecList.setParent(this);
        this.Method=Method;
        if(Method!=null) Method.setParent(this);
    }

    public MethodDecList getMethodDecList() {
        return MethodDecList;
    }

    public void setMethodDecList(MethodDecList MethodDecList) {
        this.MethodDecList=MethodDecList;
    }

    public Method getMethod() {
        return Method;
    }

    public void setMethod(Method Method) {
        this.Method=Method;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecList!=null) MethodDecList.accept(visitor);
        if(Method!=null) Method.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecList!=null) MethodDecList.traverseTopDown(visitor);
        if(Method!=null) Method.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecList!=null) MethodDecList.traverseBottomUp(visitor);
        if(Method!=null) Method.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclerations(\n");

        if(MethodDecList!=null)
            buffer.append(MethodDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Method!=null)
            buffer.append(Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclerations]");
        return buffer.toString();
    }
}
