import java.util.HashMap;

public class FibonacciSeriesUsecases {
    public static HashMap<Long, Long> fib;
    public static final long M = 1000000007l;  // modulo, to avoid overflow

    public static void main(String[] args) {
        // recurrence relation : f(n) = f(n-1) + f(n-2)

        // Use Cases:
        // 1. Find the number of boolean strings of length N, with no consecutive one's
        // 2. Find the number of ways to build a wall of size 2 X N, with bricks of size 1 X 2 and 2 X 1

        // -------------- Fibonacci for large numbers ------------------

        fib = new HashMap<>();
        fib.put(1l, 1l);
        fib.put(0l, 1l);
        System.out.println(Fibonacci(30));

        fib = new HashMap<>();
        fib.put(1l, 1l);
        fib.put(0l, 1l);
        System.out.println(Fibonacci(3));

        // Some other facts
        // Pisano Period:
        // Last 1/2/3/4 digits of fibonacci numbers repeat with period of
        // 60/300/1500/15000 respectively.
    }

    // fibonacci for large numbers [ 10^18 ]
    // Recurrence Relation :
    // f(2k) = f(k) * f(k) + f(k-1) * f(k-1)   => for even
    // f(2k + 1) = f(k) * f(k+1) + f(k-1)*f(k)  => for odd
    // T(N) = O(logn * loglogn)
    public static long Fibonacci(long n)
    {
        if(fib.containsKey(n))  // memoize
            return fib.get(n);

        long k = n/2;

        if( n%2 == 0)  // n = 2*k
        {
            long val = (Fibonacci(k)*Fibonacci(k) + Fibonacci(k-1)*Fibonacci(k-1)) % M;
            fib.put(n, val);
            return val;
        }

        else  // n = 2*k + 1
        {
            long val = (Fibonacci(k)*Fibonacci(k+1) + Fibonacci(k-1)*Fibonacci(k)) % M;
            fib.put(n, val);
            return val;
        }
    }
}
