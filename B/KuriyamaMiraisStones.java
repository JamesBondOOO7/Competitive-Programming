import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long[] strg = new long[n + 1];
        int[] sorted_arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
            sorted_arr[i] = arr[i];

            strg[i + 1] = strg[i] + arr[i];
        }

        Arrays.sort(sorted_arr);
        long[] strg_sort = new long[n + 1];
        for(int i=0; i<n; i++)
        {
            strg_sort[i + 1] = strg_sort[i] + sorted_arr[i];
        }
        
        int m = sc.nextInt();
        while( m>0 )
        {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            long ans = 0;
            if( type == 1 )
            {
                System.out.println(strg[r] - strg[l-1]);
            }
            else
            {
                System.out.println(strg_sort[r] - strg_sort[l-1]);
            }
            m--;
        }

    }
}