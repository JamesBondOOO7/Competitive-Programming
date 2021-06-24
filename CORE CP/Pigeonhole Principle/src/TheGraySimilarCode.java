import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.StringTokenizer;

public class TheGraySimilarCode {
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
        int n = sc.nextInt();

        if( n>= 130 )
            System.out.println("Yes");

        else {
            BigInteger[] arr = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new BigInteger(sc.next());
            }


            System.out.println(grayCode(arr, n) ? "Yes" : "No");
        }
    }

    public static boolean grayCode(BigInteger[] arr, int n)
    {
        BigInteger zero = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if( (arr[i].xor(arr[j].xor(arr[k].xor(arr[l])))).equals(zero) )
                            return true;
                    }
                }
            }
        }

        return false;
    }
}