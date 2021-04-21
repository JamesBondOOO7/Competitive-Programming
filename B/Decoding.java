import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        if( n <= 2 )
            System.out.println(str);

        else
        {
            String ans = str.substring(n-2, n);
            for(int i=n-3; i>=0; i--)
            {
                char ch = str.charAt(i);
                int pos = ans.length()/2;
                ans = ans.substring(0, pos) + ch + ans.substring(pos);
            }

            System.out.println(ans);
        }
    }
}