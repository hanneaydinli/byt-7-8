
package a_Introductory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuadrilateralTest {
    Quadrilateral square1;
    Quadrilateral square2;
    Quadrilateral rectangle1;
    Quadrilateral rectangle2;
    Quadrilateral quad;

    public QuadrilateralTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.square1 = new Quadrilateral(new Point(2, 3), new Point(4, 7), new Point(8, 5), new Point(6, 1));
        this.square2 = new Quadrilateral(new Point(-1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
        this.rectangle1 = new Quadrilateral(new Point(4, 2), new Point(3, 4), new Point(9, 7), new Point(10, 5));
        this.rectangle2 = new Quadrilateral(new Point(-2, -1), new Point(-2, 1), new Point(2, 1), new Point(2, -1));
        this.quad = new Quadrilateral(new Point(-2, -2), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
    }

    @Test
    public void testRectangle() {
        String msg = "Should be a rectangle";
        Assert.assertTrue(msg, this.square1.isRectangle());
        Assert.assertTrue(msg, this.square2.isRectangle());
        Assert.assertTrue(msg, this.rectangle1.isRectangle());
        Assert.assertTrue(msg, this.rectangle2.isRectangle());
        Assert.assertFalse("Should not be a rectangle", this.quad.isRectangle());
    }

    @Test
    public void testSquare() {
        String tmsg = "Should be a square";
        String fmsg = "Should not be a square";
        Assert.assertTrue(tmsg, this.square1.isSquare());
        Assert.assertTrue(tmsg, this.square2.isSquare());
        Assert.assertFalse(fmsg, this.rectangle1.isSquare());
        Assert.assertFalse(fmsg, this.rectangle2.isSquare());
        Assert.assertFalse(fmsg, this.quad.isSquare());
    }
}
