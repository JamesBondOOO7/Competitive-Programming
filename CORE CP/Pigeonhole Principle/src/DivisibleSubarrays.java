import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class DivisibleSubarrays {
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
        while( t --> 0 )
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
            }

            System.out.println(divSub(arr, n));
        }
    }

    public static long divSubarrays(int[] arr, int n)
    {
        long [] cumm = new long[n+1];
        for (int i = 1; i <= n ; i++)
        {
            cumm[i] = cumm[i-1] + arr[i-1];
        }

        for (int i = 0; i <= n; i++)
        {
            cumm[i] = ((cumm[i] % n) + n)%n;
        }

        // Pigeon hole
        // Same cumm values will lie in the same hole
        int[] freq = new int[n];
        for(long ele : cumm)
        {
            freq[(int)ele] += 1;
        }

        long ans = 0;
        for(int ele : freq )
            ans += ((long)(ele) * (long)(ele - 1))/2;

        return ans;
    }

    public static long divSub(int[] arr, int n)
    {
        int[] pre = new int[n];
        int sum = 0;
        pre[0] = 1;
        for(int i = 0; i<n; i++)
        {
            sum += arr[i];
            sum %= n;
            // handling if sum is negative
            sum = (sum + n) % n;
            pre[sum]++;
        }

        long ans = 0;
        for(int ele : pre )
        {
            ans += ((long)ele * (long)(ele - 1))/2;
        }
        return ans;
    }
}