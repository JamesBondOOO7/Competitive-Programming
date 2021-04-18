import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] map = new int[26];

        for( int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            map[ch-'a']++;
        }

        int count = 0;
        for(int ele : map )
        {
            if( ele >= 1 )
                count++;
        }

        if( count % 2 == 0 )
            System.out.println("CHAT WITH HER!");

        else
            System.out.println("IGNORE HIM!");
    }
}