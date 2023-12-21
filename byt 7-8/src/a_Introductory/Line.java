package a_Introductory;

public class Line {
    private Point p1;
    private Point p2;

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector2D getVector() {
        return new Vector2D(this.p1, this.p2);
    }

    public Double getLength() {
        return Math.sqrt(Math.pow((double)(this.p2.x - this.p1.x), 2.0D) + Math.pow((double)(this.p2.y - this.p1.y), 2.0D));
    }

    public Boolean isSameLengthAs(Line l) {
        return Math.abs(this.getLength() - l.getLength()) < 1.0E-5D;
    }
}
