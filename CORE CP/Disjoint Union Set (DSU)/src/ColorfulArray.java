import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class ColorfulArray {
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
        int q = sc.nextInt();

        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++)
        {
            queries[i][0] = sc.nextInt();  // l
            queries[i][1] = sc.nextInt();  // r
            queries[i][2] = sc.nextInt();  // c
        }

        int[] color = colorArray(queries, n, q);
        for (int i = 1; i < color.length; i++) {
            System.out.println(color[i]);
        }
    }

    public static int[] colorArray(int[][] queries, int n, int q)
    {
        int[] parent = new int[n+2];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] color = new int[n+1];

        for(int i = q-1; i>=0; i--)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int c = queries[i][2];

            // rightmost non colored index
            int index = get_parent(l, parent);
            while( index <= r)
            {
                color[index] = c;

                // if the next element to the index is not colored
                // then index's parent will become index + 1
                // otherwise, index's parent will reach to the rightmost non colored
                // index of the color array ||  AMAZING !!
                unite(index, index + 1, parent);
                index = get_parent(index, parent);
            }
        }
        return color;
    }

    public static int get_parent(int curr, int[] parent)
    {

        return (curr == parent[curr] ? curr : (parent[curr] = get_parent(parent[curr], parent) ) );
    }

    public static void unite(int x, int y, int[] parent)
    {
        // get their parents
        x = get_parent(x, parent);
        y = get_parent(y, parent);

        if( x != y )
        {
            parent[x] = Math.max(parent[x], parent[y]);  // WHY ?
            parent[y] = Math.max(parent[x], parent[y]);
            // because we want to shift to the rightmost index
        }
    }
}