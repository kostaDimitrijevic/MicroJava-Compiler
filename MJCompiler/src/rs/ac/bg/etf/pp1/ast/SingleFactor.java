// generated with ast extension for cup
// version 0.8
// 18/7/2022 12:23:36


package rs.ac.bg.etf.pp1.ast;

public class SingleFactor extends Factor {

    private BaseExp BaseExp;

    public SingleFactor (BaseExp BaseExp) {
        this.BaseExp=BaseExp;
        if(BaseExp!=null) BaseExp.setParent(this);
    }

    public BaseExp getBaseExp() {
        return BaseExp;
    }

    public void setBaseExp(BaseExp BaseExp) {
        this.BaseExp=BaseExp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseExp!=null) BaseExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseExp!=null) BaseExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseExp!=null) BaseExp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleFactor(\n");

        if(BaseExp!=null)
            buffer.append(BaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleFactor]");
        return buffer.toString();
    }
}
