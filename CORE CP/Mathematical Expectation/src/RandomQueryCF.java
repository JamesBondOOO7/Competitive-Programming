import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class RandomQueryCF {
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

    public static long MOD = (long)Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for(int i=1; i<=n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(randomQuery(arr, n));
    }

    public static double randomQuery(int[] arr, int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        double[] unqEleSubs = new double[n+1];  // It will store the sum of number of unique
        // elements in the subarrays till i

        double sum = 0.0;  // it will store the sum of all the unique elements
        // for all the subarrays
        // at the end, all we have to do is 1/(n*n) * (unqElem(l...r)) for all l to r
        // sum will store this sum of unique elements
        for(int i = 1; i <= n; i++)
        {
            unqEleSubs[i] = unqEleSubs[i-1] + i - map.getOrDefault(arr[i], 0);
            map.put(arr[i], i);

            sum += unqEleSubs[i];
        }

        // now if l>r, then swap l and r
        // Therefore, for the same l and r, we have to count the sum twice
        // except when l == r
        // those are n cases

        return ((2*(sum - n) + n)) / (n*n*1.0);
    }
}