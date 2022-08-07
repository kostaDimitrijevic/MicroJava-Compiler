// generated with ast extension for cup
// version 0.8
// 7/7/2022 17:2:57


package rs.ac.bg.etf.pp1.ast;

public class HasVarDecList extends OptionalVarDecList {

    private OptionalVarDecList OptionalVarDecList;
    private VarDecList VarDecList;

    public HasVarDecList (OptionalVarDecList OptionalVarDecList, VarDecList VarDecList) {
        this.OptionalVarDecList=OptionalVarDecList;
        if(OptionalVarDecList!=null) OptionalVarDecList.setParent(this);
        this.VarDecList=VarDecList;
        if(VarDecList!=null) VarDecList.setParent(this);
    }

    public OptionalVarDecList getOptionalVarDecList() {
        return OptionalVarDecList;
    }

    public void setOptionalVarDecList(OptionalVarDecList OptionalVarDecList) {
        this.OptionalVarDecList=OptionalVarDecList;
    }

    public VarDecList getVarDecList() {
        return VarDecList;
    }

    public void setVarDecList(VarDecList VarDecList) {
        this.VarDecList=VarDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalVarDecList!=null) OptionalVarDecList.accept(visitor);
        if(VarDecList!=null) VarDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseTopDown(visitor);
        if(VarDecList!=null) VarDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalVarDecList!=null) OptionalVarDecList.traverseBottomUp(visitor);
        if(VarDecList!=null) VarDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasVarDecList(\n");

        if(OptionalVarDecList!=null)
            buffer.append(OptionalVarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecList!=null)
            buffer.append(VarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasVarDecList]");
        return buffer.toString();
    }
}
