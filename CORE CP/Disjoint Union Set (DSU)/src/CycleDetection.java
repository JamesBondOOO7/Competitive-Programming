import java.util.ArrayList;

public class CycleDetection {
    static class Graph
    {
        static class Node
        {
            int u;
            int v;

            Node(int u, int v)
            {
                this.u = u;
                this.v = v;
            }
        }
        // ***** GRAPH IN THE FORM OF ADJACENCY LIST *****
        int V;
        ArrayList<Node> graph;
        Graph(int V)
        {
            this.V = V;
            graph = new ArrayList<>();
        }

        public void addEdge(int u, int v)
        {
            Node nn = new Node(u, v);
            this.graph.add(nn);
        }

        // FIND function
        public int findSet(int i, int[] parent)
        {
            // recursively call in the parent array until you get -1
            // which indicates that the element is the root/leader element
            if(parent[i] == -1)
                return i;

            return findSet(parent[i], parent);
        }

        // UNION function
        public void union(int x, int y, int[] parent)
        {
            // find parents of x and y
            // set parent of one as parent of another
            int px = findSet(x, parent);
            int py = findSet(y, parent);

            if( px != py )
                parent[px] = py;
        }

        public boolean contains_cycle()
        {
            // DSU logic to check if graph contains cycle or not
            int[] parent = new int[this.V + 1];
            for (int i = 0; i < this.V; i++) {
                parent[i] = -1;  // each element is in it's different set
            }

            // iterate over the edge list
            for(Node nn : this.graph)
            {
                int u = nn.u;
                int v = nn.v;

                int pu = findSet(u, parent);
                int pv = findSet(v, parent);

                if( pu != pv )
                    union(pu, pv, parent);
                else{
                    System.out.println("Same parents " + pu + " and " + pv + " for nodes " + u + " -- " + v);
                    return true;  // if the parents for both of them is same => cycle exists
                }
            }

            parent = null;  // clearing space
            return false;
        }


        // ------------------------ OPTIMIZING TO O(1) -------------------------


        public int findSetOptimized(int i, int[] parent)
        {
            // ***** PATH COMPRESSION OPTIMIZATION *****
            if(parent[i] == -1)
                return i;

            // int p = findSetOptimized(parent[i], parent);
            // parent[i] = p;
            // return p;
            // OR in short :
            return parent[i] = findSetOptimized(parent[i], parent);
        }

        public void union_byRank(int x, int y, int[] parent, int[] rank)
        {
            // find parents of x and y
            // set parent of one as parent of another
            // ON THE BASIS OF RANK
            int px = findSet(x, parent);
            int py = findSet(y, parent);

            if( px != py )
            {
                if(rank[px] < rank[py])
                {
                    parent[px] = py;  // attach the smaller sized set
                    rank[py] += rank[px];  // update the size/rank
                }

                else
                {
                    parent[py] = px;  // attach the smaller sized set
                    rank[px] += rank[py];  // update the size/rank
                }
            }
        }

        public boolean contains_cycle_optimized()
        {
            // DSU logic to check if graph contains cycle or not
            int[] parent = new int[this.V + 1];
            int[] rank = new int[this.V + 1];
            for (int i = 0; i < this.V; i++) {
                parent[i] = -1;  // each element is in it's different set
                rank[i] = 1;  // rank of each element is 1
            }

            // iterate over the edge list
            for(Node nn : this.graph)
            {
                int u = nn.u;
                int v = nn.v;

                int pu = findSetOptimized(u, parent);
                int pv = findSetOptimized(v, parent);

                if( pu != pv )
                    union_byRank(pu, pv, parent, rank);
                else
                {
                    System.out.println("Same parents " + pu + " and " + pv + " for nodes " + u + " -- " + v);
                    return true;  // if the parents for both of them is same => cycle exists
                }
            }

            parent = null;  // clearing space
            rank = null;
            return false;
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(graph.contains_cycle());
        System.out.println(graph.contains_cycle_optimized());

        graph.addEdge(4, 1);

        System.out.println(graph.contains_cycle());
        System.out.println(graph.contains_cycle_optimized());
    }
}
