import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        if( n!= 2)
        {
            long prod = 1;
            for(int i=2; i<n-1; i++)
            {
                if( GCD(i, n) == 1 )
                {
                    ans.add(i);
                    prod *= i;
                    prod = prod%n;
                }
            }

            prod *= n-1;
            if( prod % n == 1 )
                ans.add(n-1);

        }

        System.out.println(ans.size());
        for(Integer ele : ans )
            System.out.print(ele + " ");
    }

    public static int GCD(int a, int b)
    {
        if (b == 0)
        return a;

        return GCD(b, a % b);
    }
}