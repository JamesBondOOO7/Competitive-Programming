import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t>0 )
        {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String ANS = TMT(str, n) ? "YES" : "NO";
            System.out.println(ANS);
            t--;
        }
    }

    public static boolean TMT(String str, int n)
    {
        int Tcount = 0;
        int Mcount = 0;
        for(int i=0; i<n; i++)
        {
            char ch = str.charAt(i);
            if( ch == 'T' )
                Tcount++;

            else
            {
                if( Tcount <= 0 )
                    return false;

                
                Tcount--;
                Mcount++;
            }
        }

        if( Tcount != Mcount )
            return false;

        Tcount = 0;
        Mcount = 0;
        for(int i=n-1; i>=0; i--)
        {
            char ch = str.charAt(i);
            if( ch == 'T' )
                Tcount++;

            else
            {
                if( Tcount <= 0 )
                    return false;

                
                Tcount--;
                Mcount++;
            }
        }

        if( Tcount != Mcount )
            return false;
        
        return true;
    }
}