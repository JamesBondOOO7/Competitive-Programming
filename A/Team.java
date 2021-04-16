import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int total = 0;
        for(int i=0; i<n; i++)
        {
            int temp = 0;
            for(int j=0; j<3; j++)
            {
                temp += sc.nextInt();
            }

            if( temp >= 2 )
                total++;
        }

        System.out.println(total);
    }
}