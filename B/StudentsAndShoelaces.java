import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][n];
        for(int i=0; i<m; i++)
        {
            int v1 = sc.nextInt()-1;
            int v2 = sc.nextInt()-1;

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        studentClub(graph, n, m);
    }

    public static void studentClub(int[][] graph, int n, int m)
    {
        int[] indegree = new int[n];
        for(int i = 0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if( graph[i][j] == 1 )
                    indegree[i]++;
            }
        }

        int grps = 0;
        while(true)
        {
            boolean flag = true;
            boolean[] visited = new boolean[n];
            for(int i=0; i<n; i++)
            {
                if( indegree[i] == 1 && !visited[i] )
                {
                    indegree[i]--;
                    if(flag)
                        grps++;

                    flag = false;

                    for(int j = 0; j<n; j++)
                    {
                        if(graph[i][j] == 1 )
                        {
                            indegree[j]--;
                            visited[j] = true;
                        }
                    }
                }

            }

            if(flag)
            {
                // grps--;
                break;
            }

            
        }

        System.out.println(grps);
    }
}
