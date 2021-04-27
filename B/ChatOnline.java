import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        int[][] z = new int[p][2];
        int[][] x = new int[q][2];

        for(int i=0; i<p; i++)
        {
            z[i][0] = sc.nextInt();
            z[i][1] = sc.nextInt();
        }

        for(int i=0; i<q; i++)
        {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
        }

        int count = 0;

        for(int t =l; t<=r; t++)
        {
            boolean found = false;
            for(int i = 0; i<q; i++)
            {
                int s = x[i][0] + t;
                int e = x[i][1] + t;

                for(int j=0; j<p; j++)
                {
                    if( !( e < z[j][0] || s > z[j][1] ) )
                    {
                        count++;
                        found = true;
                        break;
                    }
                }

                if( found )
                    break;
            }
        }

        System.out.println(count);
    }
}