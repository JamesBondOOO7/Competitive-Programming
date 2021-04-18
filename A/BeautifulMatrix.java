import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                int val = sc.nextInt();
                if( val == 1 )
                {
                    x = i;
                    y = j;
                }
            }
        }

        int ans = Math.abs(x-2) + Math.abs(y-2);
        System.out.println(ans);


    }
}