import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Graph Adjacency matrix
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u-1).add(v-1);
        }

        // DFS
        DFS(graph, n);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> graph, int V)
    {
        long ans = 0;
        for(int i=0; i<V; i++)
        {
            boolean[] visited = new boolean[V];
            DFS_Util(graph, i, visited);
            for(int j=0; j<V; j++)
            {
                if( visited[j] )
                    ans++;
            }
        }

        System.out.println(ans);
    }

    public static void DFS_Util(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited)
    {
        visited[i] = true;
        
        for(int ele : graph.get(i))
        {
            if( !visited[ele] )
                DFS_Util(graph, ele, visited);
        }
    }
}