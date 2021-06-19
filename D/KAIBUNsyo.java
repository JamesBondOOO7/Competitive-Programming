import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class D {
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

        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        System.out.println(editPalin(arr, n, max));
    }

    public static int editPalin(int[] arr, int n, int max)
    {
        int[] parent = new int[max + 1];
        int[] rank = new int[max + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);

        int left = 0, right = n-1, cost = 0;

        while( left < right )
        {
            if( arr[left] == arr[right] )
            {
                left++;
                right--;
                continue;
            }

            else
            {
                int pl = find(arr[left], parent);
                int pr = find(arr[right], parent);

                if( pl != pr )
                {
                    cost++;
                    union(pl, pr, parent, rank);
                }
            }

            left++;
            right--;
        }

        return cost;
    }

    public static int find(int i, int[] parent)
    {
        if(parent[i] == -1)
            return i;

        return parent[i] = find(parent[i], parent);
    }

    public static void union(int i, int j, int[] parent, int[] rank)
    {
        int pi = find(i, parent);
        int pj = find(j, parent);

        if( pi != pj )
        {
            if( rank[pi] < rank[pj] )
            {
                parent[pi] = pj;
                rank[pj] += rank[pi];
            }
            else
            {
                parent[pj] = pi;
                rank[pi] += rank[pj];
            }
        }
    }
}