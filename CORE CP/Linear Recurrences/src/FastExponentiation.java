public class FastExponentiation {
    public static void main(String[] args) {
        // FAST EXPONENTIATION
        System.out.println(pow(2, 10));  // 2^10
    }

    // T(N) = O(logn)
    public static int pow(int a, int n)
    {
        if( n==0 ) return 1;

        // Sub-problem
        int subprob = pow(a, n/2);

        // check if n is odd
        if( (n&1) == 1 )
            return a*subprob*subprob;

        return subprob*subprob;
    }
}
