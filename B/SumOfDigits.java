import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        if(str.length() == 1 )
            System.out.println(0);

        else
        {
            int num = DigitSum(str);
            int count = 1;
            while( true )
            {
                str = num + "";
                if( str.length() == 1 )
                {
                    System.out.println(count);
                    break;
                }
                count++;
                num = DigitSum(str);
            }
        }
    }

    public static int DigitSum(String str)
    {
        int num = 0;
        for(int i=0; i<str.length(); i++)
            num += str.charAt(i) - '0';

        return num;
    }
}