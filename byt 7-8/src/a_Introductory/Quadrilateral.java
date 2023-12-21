
package a_Introductory;

public class Quadrilateral {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Line l1;
    private Line l2;
    private Line l3;
    private Line l4;

    Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.l1 = new Line(p1, p2);
        this.l2 = new Line(p2, p3);
        this.l3 = new Line(p3, p4);
        this.l4 = new Line(p4, p1);
    }

    public Boolean isRectangle() {
        Vector2D v1 = this.l1.getVector();
        Vector2D v2 = this.l2.getVector();
        Vector2D v3 = this.l3.getVector();
        Vector2D v4 = this.l4.getVector();
        return v1.isOrthogonalTo(v2) && v2.isOrthogonalTo(v3) && v3.isOrthogonalTo(v4) && v4.isOrthogonalTo(v1);
    }

    public Boolean isSquare() {
        return this.isRectangle() && this.l1.isSameLengthAs(this.l2) && this.l2.isSameLengthAs(this.l3) && this.l3.isSameLengthAs(this.l4);
    }
}
