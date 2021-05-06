import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        int k = sc.nextInt();
        int[] dx = new int[k];
        int[] dy = new int[k];

        for(int i=0; i<k; i++)
        {
            dx[i] = sc.nextInt();
            dy[i] = sc.nextInt();
        }

        long steps = 0;
        for(int i=0; i<k; i++)
        {
            int sx = Integer.MAX_VALUE;
            int sy = Integer.MAX_VALUE;

            if( dx[i] != 0 )
            {
                if( dx[i] > 0 )
                    sx = Math.abs((n - x)/dx[i]);

                else
                    sx = Math.abs((x - 1)/dx[i]);
            }

            if( dy[i] != 0 )
            {
                if( dy[i] > 0 )
                    sy = Math.abs((m - y)/dy[i]);

                else
                    sy = Math.abs((y - 1)/dy[i]);
            }

            int s = Math.min(sx, sy);

            if( s == Integer.MAX_VALUE )
                continue;
            
            // System.out.println("Curr coordinates : (" + x + "," + y + ")");
            x += s*dx[i];
            y += s*dy[i];
            steps += s;
        }

        System.out.println(steps);
    }
}