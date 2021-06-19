import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Pairing {
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

    static class Graph
    {
        static class Node
        {
            int u, v;
            Node(int u, int v)
            {
                this.u = u;
                this.v = v;
            }
        }

        int V;
        ArrayList<Node> graph;
        Graph(int V)
        {
            this.V = V;
            this.graph = new ArrayList<>();
        }

        public void addEdge(int u, int v)
        {
            Node nn = new Node(u, v);
            this.graph.add(nn);
        }

        public long pairing()
        {
            int[] parent = new int[this.V];
            int[] rank = new int[this.V];

            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);

            for(Node nn : this.graph)
            {
                int u = nn.u;
                int v = nn.v;

                union(u, v, parent, rank);
            }

            long total = ((long) this.V * (long) (this.V - 1))/2;
            long ways = 0;
            for(int ele : rank)
            {
                if(ele < 0)
                {
                    int e = Math.abs(ele);
                    ways += ((long)e * (long) (e - 1))/2;
                }
            }

            return total - ways;
        }

        public int find(int i, int[] parent)
        {
            if(parent[i] == -1)
                return i;

            return parent[i] = find(parent[i], parent);
        }

        public void union(int i, int j, int[] parent, int[] rank)
        {
            int pi = find(i, parent);
            int pj = find(j, parent);

            if( pi != pj )
            {
                int rank_pi = Math.abs(rank[pi]);
                int rank_pj = Math.abs(rank[pj]);
                if( rank_pi < rank_pj )
                {
                    parent[pi] = pj;
                    rank[pj] = -(rank_pi + rank_pj);
                    rank[pi] = rank_pi;
                }
                else
                {
                    parent[pj] = pi;
                    rank[pi] = -(rank_pi + rank_pj);
                    rank[pj] = rank_pj;
                }
            }
        }

    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.addEdge(u, v);
        }

        System.out.println(graph.pairing());
    }
}