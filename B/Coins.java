import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] deno = new int[3];
        for(int i=0; i<3; i++)
        {
            String str = sc.nextLine();
            int c1 = str.charAt(0)-'A';
            char sign = str.charAt(1);
            int c2 = str.charAt(2)-'A';

            if( sign == '>' )
            {
                deno[c1]++;
                deno[c2]--;
            }
            else
            {
                deno[c1]--;
                deno[c2]++;
            }
        }

        int A = deno[0], B = deno[1], C = deno[2];

        if( A == B || B == C || C == A )
            System.out.println("Impossible");

        else
        {
            if( A>B && A>C )
            {
                if( B>C )
                    System.out.println("CBA");

                else
                    System.out.println("BCA");
            }

            else if( B>A && B>C )
            {
                if( A>C )
                    System.out.println("CAB");

                else
                    System.out.println("ACB");
            }

            else // C>A && C>B
            {
                if( A>B )
                    System.out.println("BAC");

                else
                    System.out.println("ABC");
            }
        }
    }
}