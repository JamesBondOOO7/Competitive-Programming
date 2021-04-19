import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int upper = 0;
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if( ch >= 'a' && ch <= 'z' )
                upper--;

            else if( ch >= 'A' && ch <= 'Z' )
                upper++;
        }

        if( upper > 0 )
            System.out.println(str.toUpperCase());

        else
            System.out.println(str.toLowerCase());
    }
}