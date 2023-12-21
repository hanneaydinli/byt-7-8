
package a_Introductory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Vector2DTest {
    Vector2D v1;
    Vector2D v2;
    Vector2D v3;

    public Vector2DTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.v1 = new Vector2D(-2, 4);
        this.v2 = new Vector2D(1, 2);
        this.v3 = new Vector2D(2, 1);
    }

    @Test
    public void testDotProduct() {
        Assert.assertEquals("v1 and v3 are orthogonal. The dot product should be zero.", 0L, (long)this.v1.dotProduct(this.v3));
        Assert.assertEquals("The dot product of v1 and v2 should be (-2 * 1) + (4 * 2) = 6", 6L, (long)this.v1.dotProduct(this.v2));
    }

    @Test
    public void testOrthogonality() {
        Assert.assertFalse("v1 should not be orthogonal to v2", this.v1.isOrthogonalTo(this.v2));
        Assert.assertTrue("v1 should be orthogonal to v3", this.v1.isOrthogonalTo(this.v3));
    }
}
