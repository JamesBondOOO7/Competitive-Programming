public class FastExponentiation {
    public static void main(String[] args) {
        // Using Bitwise operators
        System.out.println(power_optimized(3, 5));
        System.out.println(power_optimized(2, 10));
    }

    // T(N) = O(Log(n))
    public static int power_optimized(int a, int n)
    {
        int ans = 1;
        while( n!= 0 )
        {
            // If the bit is set, multiply by a
            if( (n&1) == 1 )
                ans *= a;

            // every time, square a
            a = a*a;
            n = n>>1;
        }

        return ans;
    }
}
