import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class C {
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
        double[][] arr = new double[n][2];
        for(int i=0; i<n; i++)
        {
            double t = sc.nextDouble();
            double s = sc.nextInt();
            double e = sc.nextInt();

            if(t==2 || t==4) e = e - 0.01;
            if(t==3 || t==4 ) s = s + 0.01;

            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return o1[0] - o2[0] > 0 ? 1 : o1[0] - o2[0] == 0 ? 0 : -1;
            }
        });

//        for(double[] t : arr)
//        {
//            System.out.println(t[0] + " -- " + t[1]);
//        }
        System.out.println(intersect(arr, n));
    }

    public static long intersect(double[][] arr, int n)
    {
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            double ps = arr[i][0];
            double pe = arr[i][1];
            for(int j = i+1; j<n; j++)
            {
                double cs = arr[j][0];
                double ce = arr[j][1];

                if( ce < ps || cs > pe ) break;

                ans += 1;
            }

//            System.out.println(ps + " -- " + pe + " ANS : " + ans);
        }
        return ans;
    }
}