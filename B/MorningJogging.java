import java.util.*;
public class Main {
    static class Node implements Comparable<Node>
    {
        int i;
        int val;

        public Node(int i, int val)
        {
            this.i = i;
            this.val = val;
        }

        public int compareTo(Node other)
        {
            return this.val - other.val;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t>0 )
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Node> heap = new PriorityQueue<Node>();
            int[][] paths = new int[n][m];

            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++)
                {
                    int val = sc.nextInt();
                    heap.add(new Node(i, val));
                }
            }

            for(int j=0; j<m; j++)
            {
                Node rn = heap.remove();
                paths[rn.i][j] = rn.val;
            }

            while( !heap.isEmpty() )
            {
                Node rn = heap.remove();
                int col = 0;
                while( col < m )
                {
                    if( paths[rn.i][col] == 0 )
                    {
                        paths[rn.i][col] = rn.val;
                        break;
                    }
                    col++;
                }
            }

            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++)
                {
                    System.out.print(paths[i][j] + " ");
                }
                System.out.println();
            }
            t--;
        }
    }
}