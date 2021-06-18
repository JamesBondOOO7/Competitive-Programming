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
    
    System.out.println(histArea(a));
 }
 
    public static int histArea(int[] arr)
    {
        int n = arr.length;
        
        // find the next smaller element for each element in the array from L to R
        int[] nseLR = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++)
        {
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i] )
            {
                nseLR[stack.pop()] = i-1;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty())
            nseLR[stack.pop()] = n-1;
            
        // find the next smaller element for each element in the array from R to L
        int[] nseRL = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            while( !stack.isEmpty() && arr[stack.peek()] > arr[i])
            {
                nseRL[stack.pop()] = i+1;
            }
            stack.push(i);
        }
        
        // while(!stack.isEmpty())
        //     nseRL[stack.pop()] = 0;
        
        int maxArea = 0;
        for(int i=0; i<n; i++)
            maxArea = Math.max(maxArea, (nseLR[i] - nseRL[i] + 1)*arr[i] );
            
        return maxArea;
    }
}