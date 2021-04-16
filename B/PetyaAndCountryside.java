import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(rain(arr, n));
    }

    public static int rain(int[] arr, int n)
    {
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            // travel the left part
            int temp = 1;
            for(int j=i-1, k=i; j>=0; j--, k--)
            {
                if( arr[k] < arr[j] )
                    break;

                temp++;
            }

            // travel the right part
            for(int j=i+1, k=i; j<n; j++, k++)
            {
                if( arr[k] < arr[j] )
                    break;

                temp++;
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}