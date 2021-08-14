import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SnakeAndLadder {
    static class Graph<T>
    {
        HashMap<T, ArrayList<T>> list;  // Generic HashMap

        Graph()
        {
            list = new HashMap<>();
        }
        public void addEdge(T x, T y)
        {
            // considering directed edges
            if( !list.containsKey(x) )
                list.put(x, new ArrayList<>());

            list.get(x).add(y);
        }

        public int bfsShortestPath(T src, T dest)
        {
            // for an unweighted graph,
            // shortest distance between src to dest = BFT from src to dest
            HashMap<T, Integer> distance = new HashMap<>();

            HashMap<T, T> parent = new HashMap<>();
            LinkedList<T> queue = new LinkedList<>();

            for ( T node : list.keySet() )
                distance.put(node, Integer.MAX_VALUE);

            distance.put(src, 0);
            parent.put(src, src);
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
                        parent.put(nbr, node);
                    }
                }
            }

            T temp = dest;
            while( temp != src )
            {
                System.out.print(temp + " <-- ");
                temp = parent.get(temp);
            }
            System.out.println(src);
            return distance.get(dest);
        }
    }

    public static void main(String[] args) {

        // Snake and Ladders

        // move = start + 1 + jump
        // for Ladder, jump > 0
        // for snake, jump < 0

        // Therefore, each dice throw is counted as 1 chance
        // Hence, this problem reduces to BFS on an Unweighted graph

        int[] board = new int[50];  // the values indicate snakes and ladders in the board
        board[2] = 13;
        board[5] = 2;
        board[9] = 18;
        board[18] = 11;
        board[17] = -13;
        board[20] = -14;
        board[24] = -8;
        board[25] = 10;
        board[32] = -2;
        board[34] = -22;

        Graph<Integer> g = new Graph<>();
        for (int i = 0; i <= 36; i++)
        {
            for (int dice = 1; dice <= 6 ; dice++)
            {
                int jump = i + dice;
                jump += board[i];

                if( jump <= 36 )
                {
                    g.addEdge(i, jump);
                }
            }
        }

        g.addEdge(36, 36);

        System.out.println(g.bfsShortestPath(0, 36));
    }
}
