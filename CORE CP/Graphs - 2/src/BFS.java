import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BFS {

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

        public void bfs(T src)
        {
            HashMap<T, Boolean> visited = new HashMap<>();
            LinkedList<T> queue = new LinkedList<>();
            queue.addLast(src);
            visited.put(src, true);

            while( !queue.isEmpty() )
            {
                T node = queue.removeFirst();
                System.out.print(node + " ");

                for(T nbr : list.get(node) )
                {
                    if( !visited.containsKey(nbr) )
                    {
                        // push the nbr to the stack
                        queue.addLast(nbr);

                        // mark the nbr as visited
                        visited.put(nbr, true);
                    }
                }
            }

            System.out.println();
        }

        public void bfsShortestPath(T src)
        {
            // for an unweighted graph,
            // shortest distance between src to dest = BFT from src to dest
            HashMap<T, Integer> distance = new HashMap<>();
            LinkedList<T> queue = new LinkedList<>();

            for ( T node : list.keySet() )
                distance.put(node, Integer.MAX_VALUE);

            distance.put(src, 0);
            queue.addLast(src);

            while( !queue.isEmpty() )
            {
                T node = queue.removeFirst();

                for(T nbr : list.get(node) )
                {
                    if( distance.get(nbr) == Integer.MAX_VALUE )
                    {
                        // push the nbr to the stack
                        queue.addLast(nbr);

                        // mark the nbr as visited
                        distance.put(nbr, distance.get(node) + 1);

                    }
                }
            }

            for(T node : distance.keySet() )
            {
                System.out.println("Node " + node + " Dist from src " + distance.get(node));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.bfs(0);
        g.bfsShortestPath(0);
    }
}
