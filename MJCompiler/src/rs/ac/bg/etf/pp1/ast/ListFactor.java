// generated with ast extension for cup
// version 0.8
// 7/7/2022 17:2:57


package rs.ac.bg.etf.pp1.ast;

public class ListFactor extends Factor {

    private Factor Factor;
    private CoalExpr CoalExpr;
    private BaseExp BaseExp;

    public ListFactor (Factor Factor, CoalExpr CoalExpr, BaseExp BaseExp) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.CoalExpr=CoalExpr;
        if(CoalExpr!=null) CoalExpr.setParent(this);
        this.BaseExp=BaseExp;
        if(BaseExp!=null) BaseExp.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public CoalExpr getCoalExpr() {
        return CoalExpr;
    }

    public void setCoalExpr(CoalExpr CoalExpr) {
        this.CoalExpr=CoalExpr;
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
        if(Factor!=null) Factor.accept(visitor);
        if(CoalExpr!=null) CoalExpr.accept(visitor);
        if(BaseExp!=null) BaseExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(CoalExpr!=null) CoalExpr.traverseTopDown(visitor);
        if(BaseExp!=null) BaseExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(CoalExpr!=null) CoalExpr.traverseBottomUp(visitor);
        if(BaseExp!=null) BaseExp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListFactor(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CoalExpr!=null)
            buffer.append(CoalExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BaseExp!=null)
            buffer.append(BaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListFactor]");
        return buffer.toString();
    }
}
