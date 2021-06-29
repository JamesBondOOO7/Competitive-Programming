import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class E {
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

    public static long MOD = (long)(Math.pow(10, 9) + 7);
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long[] arr = new long[n];
        long[] sum = new long[n+1];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
            sum[i+1] = sum[i] + arr[i];
        }

        long[][] dp = new long[n+2][n+2];
//        long[][] mem = new long[n+1][n+1];
        dp[1][0] = 1;
        long ans = 0;
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + "\t");
        }
        System.out.println();
        for(int i=0; i<n; i++)
        {
            for(int j=n; j>=1; j--)
            {
                dp[j+1][(int)(sum[i+1]%(j+1))] += dp[j][(int)(sum[i+1]%j)];
                dp[j+1][(int)(sum[i+1]%(j+1))] %= MOD;

                if( i == n-1 )
                {
                    ans += dp[j][(int)(sum[i+1] % j)];
                    ans %= MOD;
                }
            }

            System.out.println(i + " : ");
            display(dp);
        }

        System.out.println(ans);
    }

    public static void display(long[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for(long ele : arr[i])
            {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }
}