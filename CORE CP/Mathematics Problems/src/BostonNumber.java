import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BostonNumber {
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
        System.out.println(isBostonNumber(n) ? 1 : 0);
    }

    public static boolean isBostonNumber(int n)
    {
        int sum = calSum(n);
//        System.out.println("Sum : " + sum);

        int factor = 2, num = n;
        while (num != 1)
        {
            if(gcd(num, factor) != 1)
            {
                sum -= calSum(factor);
                num = num/factor;
            }
            else
                factor++;

            if( factor*factor > n )
                break;
        }

        if( num != 1)
            sum -= calSum(num);

        if(sum == 0)
            return true;

        return false;
    }

    public static int gcd(int a, int b)
    {
        if( a==0 )
            return b;

        return gcd(b%a, a);
    }

    public static int calSum(int n)
    {
        int sum = 0;
        while(n != 0)
        {
            sum += (n % 10);
            n = n / 10;
        }

        return sum;
    }
}