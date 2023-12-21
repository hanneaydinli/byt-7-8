package a_Introductory;

public class Fibonacci {
    public Fibonacci() {
    }

    public int fib(int n) {
        switch(n) {
        case 0:
            return 0;
        case 1:
            return 1;
        default:
            return this.fib(n - 1) + this.fib(n - 2) + 1;
        }
    }
}
