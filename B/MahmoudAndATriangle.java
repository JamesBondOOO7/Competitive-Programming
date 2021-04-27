import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        boolean found = false;
        for(int i=n-1; i>=2; i--)
        {
            int a = arr[i], b = arr[i-1], c = arr[i-2];
            if( check(a, b, c) )
            {
                found = true;
                break;
            }
        }

        if( found )
            System.out.println("YES");
        
        else
            System.out.println("NO");        
    }

    public static boolean check(int a, int b, int c)
    {
        if( a + b <= c || b + c <= a || c + a <= b)
            return false;

        return true;
    }
}