public class InclusionExclusion {
    public static void main(String[] args) {
        // total numbers divisible by 2, 3 or 5
        // and less than 1000 (i.e. 1...999)
        // General Formula:
        // #numbers = floor(limit/factor)
        // E.g : floor(999/2) = 499

        int[] factors = {2, 3, 5, 7, 11, 13, 17, 19};

        // calculate the subsequences using bitmasking
        // if #terms are even => +
        // else => -

        int ans = 0, n = 18;
        for(int i=1; i < (1<<(factors.length)); i++)
        {
            ans += calculateTerms(n, factors, i);
        }
        System.out.println(ans);
    }

    public static int calculateTerms(int num, int[] factors, int n)
    {
        boolean pos = true;
        if( (Integer.bitCount(n) & 1) == 0 )  // even number of elements => subtract
            pos = false;

//        System.out.print(n + " --> ");
        int den = 1, i = 0;
        while( n!=0 )
        {
            if( (n&1) == 1 )
                den *= factors[i];

            i++;
            n = n>>1;
        }

//        System.out.println(num/den);

        if(pos)
            return num/den;

        else  // odd number of elements => add
            return -num/den;
    }
}
