import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().toLowerCase();
        String s2 = sc.nextLine().toLowerCase();

        int ans = s1.compareTo(s2);

        if(ans > 0)
            ans = 1;

        else if( ans < 0)
            ans = -1;

        else ans = 0;

        System.out.println(ans);


    }
}