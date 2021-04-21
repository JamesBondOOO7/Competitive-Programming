import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] colors = {'G', 'B', 'I', 'V'};
        String ans = "";
        int rem = n%7;
        int len = n/7;
        String temp = "ROYGBIV";
        for(int i=0; i<len; i++)
            ans += temp;

        for(int i=0; i<rem; i++)
            ans += colors[ i % 4];
        
        System.out.println(ans);
    }
}