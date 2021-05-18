import java.util.*;
public class Main {
    public static long ANS;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int c1 = 0, c2 = 0;
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if( ch == 'o')
                c1++;

            else if( ch == '?')
                c2++;
        }

        if( c1 > 4 )
            System.out.println(0);

        else if( c1 == 4 )
        {
            System.out.println(24);
        }

        else
        {
            ANS = 0;
            boolean[] all_c1 = new boolean[c1];
            count(c1, c2, all_c1, 0);

            System.out.println(ANS);
        }
    }

    public static void count(int c1, int c2, boolean[] all_c1, int steps)
    {
        if( steps == 4 )
        {
            boolean temp = true;
            for(int i=0; i<c1; i++)
            {
                temp = temp & all_c1[i];
            }

            if( temp )
                ANS += 1;
            
            return;
        }
        
        for(int i=0; i<c1; i++)
        {
            if( all_c1[i] )
            {
                count(c1, c2, all_c1, steps + 1);
            }
            
            else
            {
                all_c1[i] = true;
                count(c1, c2, all_c1, steps + 1);
                all_c1[i] = false;
            }
        }

        for(int i=0; i<c2; i++)
            count(c1, c2, all_c1, steps + 1);
    }
}