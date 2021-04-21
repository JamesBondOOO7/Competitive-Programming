import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int sum = 0;
        int min = 0;
        int idx = 0;
        int i = 0;

        for(; i<k; i++)
            sum += arr[i];

        min = sum;

        for(; i<n; i++)
        {
            sum = sum - arr[i-k] + arr[i];
            // System.out.println("Sum : " + sum + " Idx : " + (i-k));
            if( sum < min )
            {
                min = sum;
                idx = i-k+1;
                // System.out.println("--> " + idx);
            }
        }
        System.out.println(idx + 1);
    }
}