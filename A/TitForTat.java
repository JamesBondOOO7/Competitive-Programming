import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t>0 )
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextLong();
            }

            TitForTat(arr, n, k);
            for(long ele : arr)
                System.out.print(ele + " ");
            
            System.out.println();
            t--;
        }
    }

    public static void TitForTat(long[] arr, int n, int k)
    {
        int start = 0;
        int end = n-1;

        for(int i=0; i<k; i++)
        {
            while( start < end && arr[start] == 0 )
                start++;

            if( start == end )
                break;

            arr[start]--;
            arr[end]++;
        }
    }
}