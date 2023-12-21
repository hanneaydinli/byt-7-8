
package a_Introductory;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    public FibonacciTest() {
    }

    @Test
    public void testFib() {
        Fibonacci tester = new Fibonacci();
        Assert.assertEquals("0", 0L, (long)tester.fib(0));
        Assert.assertEquals("1", 1L, (long)tester.fib(1));
        Assert.assertEquals("2", 2L, (long)tester.fib(2));
        Assert.assertEquals("3", 4L, (long)tester.fib(3));
        Assert.assertEquals("4", 7L, (long)tester.fib(4));
        Assert.assertEquals("5", 12L, (long)tester.fib(5));
        Assert.assertEquals("6", 20L, (long)tester.fib(6));
        Assert.assertEquals("7", 33L, (long)tester.fib(7));
    }
}
