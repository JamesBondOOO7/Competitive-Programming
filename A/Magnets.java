import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int grps = 0;
        String prev = "";
        for(int i=0; i<n; i++)
        {
            String curr = sc.nextLine();

            if( prev.length() == 0 )
                grps++;

            else if( prev.charAt(1) == curr.charAt(0) )
            {
                grps++;
            }
            prev = curr;
        }

        System.out.println(grps);
    }
}