import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class TavasAndSaDDas {
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
        String num = sc.nextLine();
        // Digits can either be 4 or 7, e.g: 4, 7, 44, 47, 74, 77, 444, ...
        // index of n in this series

        int len = num.length();
        int ans = 2*((1<<(len-1))-1);

        int temp = 1;
        for(int i=0; i<len; i++)
        {
            char ch = num.charAt(i);
//            System.out.println(ch);
            if(ch == '7')
                temp += 1<<(len - i - 1);
        }
        System.out.println(temp + ans);
    }
}