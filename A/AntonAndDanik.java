import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int c1 = 0, c2=0;
        for(int i=0; i<n; i++)
        {
            char ch = str.charAt(i);
            if( ch == 'A' )
                c1++;

            else
                c2++;
        }

        if( c1 > c2 )
            System.out.println("Anton");

        else if( c1 < c2 )
            System.out.println("Danik");

        else
            System.out.println("Friendship");
    }
}