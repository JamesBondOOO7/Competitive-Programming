import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class HoliSpoj {
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

    static class Node
    {
        int val, cost;
        Node(int val, int cost)
        {
            this.val = val;
            this.cost = cost;
        }
    }

    public static long ANS = 0;
    public static void main(String[] args) {
        // HOLIDAY ACCOMMODATION SPOJ
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for( int q = 1; q<=t; q++ )
        {
            int n = sc.nextInt();
            ArrayList<Node>[] graph = new ArrayList[n];
            for(int i=0; i<n; i++)
            {
                graph[i] = new ArrayList<Node>();
            }

            for(int i=1; i<n; i++)
            {
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                int z = sc.nextInt();

                Node u = new Node(x, z);
                Node v = new Node(y, z);

                graph[x].add(v);
                graph[y].add(u);
            }

            ANS = 0;
//            display(graph);
            util(graph, n, new boolean[n], 0);
            System.out.println("Case #" + q + ": " + ANS);
        }
    }

    public static void display(ArrayList<Node>[] graph)
    {
        for (int i = 0; i < graph.length; i++)
        {
            for (Node nbr : graph[i])
            {
                System.out.println(i + " - " + nbr.val + " : " + nbr.cost);
            }
        }
    }

    public static int util(ArrayList<Node>[] graph, int n, boolean[] visited, int ci)
    {
        if( visited[ci] )
            return 1;

        visited[ci] = true;

        int count = 1;
        for(Node nbr : graph[ci] )
        {
            int vtx = nbr.val;
            int cost = nbr.cost;

            if( !visited[vtx] )
            {
                int x = util(graph, n, visited, vtx);
                ANS += (2 * Math.min(x, n-x) * cost);
                count += x;
            }
        }

        return count;
    }
}
