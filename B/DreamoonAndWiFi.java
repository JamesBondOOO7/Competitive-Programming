import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        int pos = 0, neg = 0;

        for(int i=0; i<s1.length(); i++)
        {
            char ch = s1.charAt(i);
            if( ch == '+' )
                pos++;
            
            else
                neg++;
        }

        // System.out.println(pos + " -- " + neg);
        int miss = 0;
        for(int i=0; i<s2.length(); i++)
        {
            char ch = s2.charAt(i);
            if( ch == '+' )
                pos--;

            else if( ch == '-' )
                neg--;

            else
                miss++;
        }

        double ans = 0.0;
        if( pos < 0 || neg < 0 )
            System.out.println(ans);

        else
        {
            if(miss == 0 && (pos != 0 || neg !=0) )
            {
                System.out.println(ans);
            }
            else
            {
                double num = getArrangement(miss, pos, neg);
                // System.out.println(num + " " + pos + " " + neg);
                double den = Math.pow(2, miss);
                ans = num/den;
                System.out.println(ans);
            }
        }
    }

    public static double getArrangement(int miss, int pos, int neg)
    {
        return fact(miss)/( fact(pos) * fact(neg) );
    }

    public static double fact(int num)
    {
        if( num <= 1)
            return (double)1.0;

        double fact = 1.0;

        for(int i=num; i>=2; i--)
            fact *= i;

        return fact;
    }
}