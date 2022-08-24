// generated with ast extension for cup
// version 0.8
// 18/7/2022 12:12:11


package rs.ac.bg.etf.pp1.ast;

public class NegativNumberConst extends BaseExp {

    private Integer val;

    public NegativNumberConst (Integer val) {
        this.val=val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val=val;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NegativNumberConst(\n");

        buffer.append(" "+tab+val);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NegativNumberConst]");
        return buffer.toString();
    }
}
