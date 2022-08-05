// generated with ast extension for cup
// version 0.8
// 5/7/2022 17:8:23


package rs.ac.bg.etf.pp1.ast;

public class Prints extends Printable {

    private Printable Printable;
    private Integer N2;

    public Prints (Printable Printable, Integer N2) {
        this.Printable=Printable;
        if(Printable!=null) Printable.setParent(this);
        this.N2=N2;
    }

    public Printable getPrintable() {
        return Printable;
    }

    public void setPrintable(Printable Printable) {
        this.Printable=Printable;
    }

    public Integer getN2() {
        return N2;
    }

    public void setN2(Integer N2) {
        this.N2=N2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Printable!=null) Printable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Printable!=null) Printable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Printable!=null) Printable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Prints(\n");

        if(Printable!=null)
            buffer.append(Printable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Prints]");
        return buffer.toString();
    }
}
