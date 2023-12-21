package a_Introductory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    Point p1;
    Point p2;
    Point p3;

    public PointTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.p1 = new Point(7, 9);
        this.p2 = new Point(-3, -30);
        this.p3 = new Point(-10, 3);
    }

    @Test
    public void testAdd() {
        Point res1 = this.p1.add(this.p2);
        Point res2 = this.p1.add(this.p3);
        Assert.assertEquals(4, res1.x);
        Assert.assertEquals(-21, res1.y);
        Assert.assertEquals(-3, res2.x);
        Assert.assertEquals(-3, res2.x);
    }

    @Test
    public void testSub() {
        Point res1 = this.p1.sub(this.p2);
        Point res2 = this.p1.sub(this.p3);
        Assert.assertEquals(10, res1.x);
        Assert.assertEquals(39, res1.y);
        Assert.assertEquals(17, res2.x);
        Assert.assertEquals(17, res2.x);
    }
}
