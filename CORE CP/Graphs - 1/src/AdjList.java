import java.util.ArrayList;

public class AdjList {

    static class Graph
    {
        int V;  // the number of vertices
        ArrayList<ArrayList<Integer>> list;
        Graph(int V)
        {
            this.V = V;
            list = new ArrayList<>();
            for (int i = 0; i < V; i++)
            {
                list.add(new ArrayList<>());
            }
        }

        public void addEdge(int x, int y)
        {
            // Assuming bi-directional graph
            list.get(x).add(y);
            list.get(y).add(x);
        }

        public void printAdjList()
        {
            for (int i = 0; i < V; i++)
            {
                System.out.print("Vertex " + i + " --> ");
                for(Integer nbr : this.list.get(i))
                {
                    System.out.print(nbr + ", ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 2);

        g.printAdjList();
    }
}
