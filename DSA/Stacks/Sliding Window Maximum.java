import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    int[] ans = slidingWindowMax(a, k);
    for(int ele : ans)
        System.out.println(ele);
 }
 
    public static int[] slidingWindowMax(int[] arr, int k)
    {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++)
        {
            while( !stack.isEmpty() && arr[stack.peek()] <= arr[i] )
            {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        while( !stack.isEmpty() )
            nge[stack.pop()] = n;
            
        int[] ans = new int[n-k+1];
        int j = 0;
        for(int i=0; i<=n-k; i++)
        {
            if( j < i )
                j=i;
                
            while( nge[j] < i + k )
                j = nge[j];
            
            ans[i] = arr[j];
        }
        
        return ans;
    }
}