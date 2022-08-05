// generated with ast extension for cup
// version 0.8
// 5/7/2022 17:8:23


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends SingleStatement {

    private Expr Expr;
    private Printable Printable;

    public PrintStatement (Expr Expr, Printable Printable) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.Printable=Printable;
        if(Printable!=null) Printable.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public Printable getPrintable() {
        return Printable;
    }

    public void setPrintable(Printable Printable) {
        this.Printable=Printable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(Printable!=null) Printable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(Printable!=null) Printable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(Printable!=null) Printable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Printable!=null)
            buffer.append(Printable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
