package a_Introductory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineTest {
    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Line l1;
    Line l2;

    public LineTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.p1 = new Point(2, -3);
        this.p2 = new Point(3, 7);
        this.l1 = new Line(this.p1, this.p2);
        this.p3 = new Point(7, 2);
        this.p4 = new Point(8, 12);
        this.l2 = new Line(this.p3, this.p4);
    }

    @Test
    public void testLength() {
        Assert.assertEquals(10.0498756D, this.l1.getLength(), 1.0E-4D);
        Assert.assertEquals(10.0498756D, this.l2.getLength(), 1.0E-4D);
        Assert.assertTrue("l1 should have same length as l2", this.l1.isSameLengthAs(this.l2));
    }
}
