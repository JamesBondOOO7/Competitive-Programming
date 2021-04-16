import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curr = sc.nextInt()-1;
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int ans = arr[curr] == 0 ? 0 : 1;

        int i=curr-1, j=curr+1;
        for(; i>=0 && j<n; i--, j++)
        {
            if( arr[i] + arr[j] == 2 )
                ans += 2;
        }

        if( i == -1 )
        {
            while( j<n )
            {
                if( arr[j] == 1 )
                    ans++;

                j++;
            }
        }

        if( j == n )
        {
            while( i>=0 )
            {
                if( arr[i] == 1 )
                    ans++;

                i--;
            }
        }
        System.out.println(ans);
    }
}