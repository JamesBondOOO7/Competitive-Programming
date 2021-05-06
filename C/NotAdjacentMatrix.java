import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t>0 )
        {
            int n = sc.nextInt();
            if( n == 1 )
                System.out.println(1);

            else if( n == 2 )
                System.out.println(-1);

            else
            {
                notAdj(n);
            }
            t--;
        }
    }

    public static void notAdj(int n)
    {
        int num = 1;
        int[][] matrix = new int[n][n];
        int col = 0;
        for(int i=0; i<n; i++)
        {
            while( col < n )
            {
                matrix[i][col] = num;
                num++;
                col += 2;
            }

            col = col % n;
        }
        
        col = 1;
        for(int i=0; i<n; i++)
        {
            while( col < n )
            {
                matrix[i][col] = num;
                num++;
                col += 2;
            }

            col = col % n;
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}