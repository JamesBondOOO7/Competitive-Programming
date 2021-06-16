import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class UniqueNumber3 {
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
        int[] arr = new int[n];

        // ex : arr = {3, 3, 2, 1, 1, 1, 3}
        // ANS => 2
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Algo
        // Take the sum of bits at each bit position
        // Each entry will be of the form 3N or 3N + 1
        // 3N + 1 => indicates that the number occurring once
        // is present at that position (WHY?)

        int[] bits = new int[32];
        for(int i=0; i<32; i++)
            bits[i] = setBitSum(arr, i)%3;  // %3 will eliminate
            // the elements repeating thrice

        // Now, we will have 1 in only those positions where we have
        // 3N + 1 form.
        // This simply indicates that the unique number is present here.
        // return its decimal form
        System.out.println(BinaryToDecimal(bits));

        // THIS CONCEPT CAN BE EXTENDED TO (2N+1) type occurrences, e.g. 5, 7, 9...
        // they will have 5N+1, 7N+1, 9N+1... type occurrences
    }

    public static int setBitSum(int[] arr, int i)
    {
        int mask = 1<<i;
        int sum = 0;
        for(int ele : arr)
            sum += (mask&ele) != 0 ? 1 : 0;
        return sum;
    }

    public static int BinaryToDecimal(int[] arr)
    {
        int ans = 0;
        for(int i=0; i<32; i++)
            ans += arr[i] == 1 ? (int)Math.pow(2, i) : 0;
        return ans;
    }
}