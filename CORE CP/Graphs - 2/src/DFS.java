import java.util.ArrayList;
import java.util.HashMap;

public class DFS {
    static class Graph<T>
    {
        HashMap<T, ArrayList<T>> list;  // Generic HashMap

        Graph()
        {
            list = new HashMap<>();
        }
        public void addEdge(T x, T y)
        {
            // considering bidirectional edges
            if( !list.containsKey(x) )
                list.put(x, new ArrayList<>());

            list.get(x).add(y);

            if( !list.containsKey(y) )
                list.put(y, new ArrayList<>());

            list.get(y).add(x);
        }

        public void dfs(T src)
        {
            HashMap<T, Boolean> visited = new HashMap<>();
            dfs_helper(src, visited);
            System.out.println();
        }

        private void dfs_helper(T src, HashMap<T, Boolean> visited)
        {
            System.out.print(src + " ");
            visited.put(src, true);
            // Visit the unvisited nbrs
            for( T nbr : list.get(src) )
            {
                if( !visited.containsKey(nbr) )
                {
                    dfs_helper(nbr, visited);
                }
            }
        }

        public int connectedComponents()
        {
            HashMap<T, Boolean> visited = new HashMap<>();
            int count = 0;

            for( T nbr : list.keySet() )
            {
                if( !visited.containsKey(nbr) )
                {
                    count++;
                    System.out.print("Component - " + count + " : ");
                    dfs_helper(nbr, visited);
                    System.out.println();
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.addEdge(5, 6);
        g.addEdge(6, 7);

        g.dfs(0);
        System.out.println("Total Components : " + g.connectedComponents());
    }
}
