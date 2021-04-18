import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = sc.nextInt();

        int ans = 0;
        int curr = 0;
        for(int i=1; i<=n; i++)
        {
            if( curr + arr[i-1] - arr[i] < 0 )
            {
                ans += -1*(curr + arr[i-1] - arr[i]);
                curr = 0;
            }
            else
            {
                curr += (arr[i-1] - arr[i]);
            }

            // System.out.println("ans : " + ans + " curr : " + curr);
        }

        System.out.println(ans);
    }
}