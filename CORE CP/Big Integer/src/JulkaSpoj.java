import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class JulkaSpoj {
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
        Scanner sc = new Scanner(System.in);
        BigInteger two = BigInteger.valueOf(2);
        for(int i=0; i<10; i++)
        {
            BigInteger sum = sc.nextBigInteger();
            BigInteger extra = sc.nextBigInteger();

            BigInteger ans = sum.subtract(extra).divide(two);
            System.out.println(ans.add(extra));
            System.out.println(ans);
        }
    }
}