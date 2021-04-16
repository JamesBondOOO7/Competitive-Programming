import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // a <= b

        int time = 1;
        while( true )
        {
            a = a*3;
            b = b*2;

            if( a>b )
            {
                System.out.println(time);
                break;
            }
            time++;
        }
    }
}