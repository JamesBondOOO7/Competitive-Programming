import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.StringTokenizer;

public class Marbles {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while( t-->0 )
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(marbles(n, k));
        }
    }

    public static BigInteger marbles(int n, int k)
    {
        // Solve using Multinomial Theorem ( PNC )
        if( k>n )
            return new BigInteger("0");

        if( n==k )
            return new BigInteger("1");

        BigInteger ans = new BigInteger("1");
        // C(n-1, k-1)

        for(long i = n-1; i>=n-k+1; i--)
        {
            ans = ans.multiply(BigInteger.valueOf(i));
            ans = ans.divide(BigInteger.valueOf(n-i));
        }

        return ans;
    }
}