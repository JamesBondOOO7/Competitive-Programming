import java.util.ArrayList;
import java.util.HashMap;

public class AdjListNodes {
    static class Node
    {
        String vtx;
        int val;

        Node(String vtx, int val)
        {
            this.vtx = vtx;
            this.val = val;
        }
    }

    static class Graph
    {
        HashMap<String, ArrayList<Node>> list;

        Graph()
        {
            this.list = new HashMap<>();
        }

        public void addEdge(String x, String y, boolean bidir, int wt)
        {
            if( !list.containsKey(x) )
                list.put(x, new ArrayList<>());

            list.get(x).add(new Node(y, wt));

            // if the edge is bidir (bidirectional)
            if(bidir)
            {
                if( !list.containsKey(y) )
                    list.put(y, new ArrayList<>());

                list.get(y).add(new Node(x, wt));
            }
        }

        public void display()
        {
            for(String vtx : list.keySet())
            {
                System.out.print("Vertex --> " + vtx + " : ");
                for(Node nbr : list.get(vtx))
                {
                    System.out.print(nbr.vtx + " " + nbr.val + ", ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B", true, 20);
        g.addEdge("B", "D", true, 40);
        g.addEdge("A", "C", true, 10);
        g.addEdge("C", "D", true, 40);
        g.addEdge("A", "D", false, 50);

        g.display();
    }
}
