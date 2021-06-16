import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class UniqueNumber2 {
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

        int xor = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
            xor = xor ^ arr[i];
        }

        // xor != 0 => there is a unique set bit at ith position
        // Therefore, the elements can be divided into 2 groups
        // where ith bit is 0 and the ith bit is 1
        int i = setBitPos(xor);
        int a = 0;
        for(int ele : arr)
        {
            if(isSet(ele, i))
                a = a^ele;
        }

        System.out.println(Math.min(a, a^xor) + " " + Math.max(a, a^xor));

    }

    public static int setBitPos(int num)
    {
        int i = 0;
        while(num != 0)
        {
            if ( (num & 1) == 1 )
                return i;

            i++;
            num &= 1;
        }

        return -1;
    }

    public static boolean isSet(int num, int i)
    {
        int mask = 1<<i;
        return (mask & num) != 0;
    }
}