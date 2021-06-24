public class MatrixExponentiation {
    public static long MOD = (long)Math.pow(10, 9);
    public static int k;
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

        System.out.println(compute(n));
    }

    public static long compute(int n)
    {
        if( n==0 )
            return 0;

        // if the nth term is pre-computed, i.e given to us
        if( n<=k )
            return b[n-1];

        // Step 1 : F1 vector
        long[] F1 = new long[k+1];
        for(int i=1; i<=k; i++)
        {
            F1[i] = b[i-1];
        }

        // Step 2 : build the transformation matrix
        long[][] T = new long[k+1][k+1];

        for (int i = 1; i <= k; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                // This part is the formation of the identity matrix
                if( i<k )
                {
                    if( j == i + 1 )
                        T[i][j] = 1;

                    else
                        T[i][j] = 0;
                }

                // This part deals with the last row, in which we use
                // coefficients in the reverse order
                else
                    T[i][j] = c[k - j];
            }
        }

        // Step 3 : Calculate T^(n-1) using matrix exponentiation
        T = pow(T, n-1);

        // Step 4 : Multiply T^(n-1) with the vector F1
        long res = 0;
        for (int i = 1; i <= k; i++)
        {
            res = (res + (T[1][i] * F1[i]) % MOD) % MOD;
        }

        return res;
    }


    public static long[][] pow(long[][] A, int p)
    {
        if( p==1 )
            return A;

        // if power is odd
        if( (p&1) == 1 )
        {
            return multiply(A, pow(A, p-1));  // p-1 will be even
        }

        // store the result for A^(p/2) and square it
        long[][] X = pow(A, p/2);

        return multiply(X, X);
    }

    public static long[][] multiply(long[][] A, long[][] B)
    {
        // both are square matrices with same dimension of ( k+1 X k+1 )
        long[][] C = new long[k + 1][k + 1];

        for (int i = 1; i <=k  ; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                for (int x = 1; x <= k ; x++)
                {
                    C[i][j] = (C[i][j] + (A[i][x] * B[x][j]) % MOD) % MOD;
                }
            }
        }

        return C;
    }
}
