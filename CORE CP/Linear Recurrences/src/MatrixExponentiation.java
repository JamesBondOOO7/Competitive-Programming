import java.util.ArrayList;
import java.util.Arrays;

public class MatrixExponentiation {
    public static long k;
    public static int[] b;
    public static int[] c;
    public static void main(String[] args) {
        k = 3;  // k terms given
        b = new int[]{1, 2, 3};  // first k terms
        c = new int[]{4, 5, 6};  // their coefficients

        int n = 6;  // nth term

        // series is :
        // a[i] = b[i] (for i <= k)
        // a[i] = c[1]a[i-1] + c[2]a[i-2] + ... + c[k]a[i-k] (for i > k)

        // in this example :
        // a1 = 1, a2 = 2, a3 = 3
        // a4 = 4a3 + 5a2 + 6a1 = 28
        // a5 = 4a4 + 5a3 + 6a2 = 139
        // a6 = 4a5 + 5a4 + 6a3 = 714
    }

    public static long compute(int n)
    {
        if( n==0 )
            return 0;

        if( n==k )
            return b[n-1];

        // step 1 : F1 vector
        ArrayList<Long> F1 = new ArrayList<>();
        F1.add(0l);
        for(int i=1; i<=k; i++)
        {
            F1.add((long)b[i-1]);
        }

        // step 2 : build the transformation matrix
//        ArrayList<Arrays<>>

        return 0l;
    }
}
