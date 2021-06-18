import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
     Stack<Integer> stack = new Stack<>();
     
     // It's nothing but next greater element on the left
     // This question is also similar to Sun shadow problem
     int[] nge = new int[arr.length];
     
     for(int i=arr.length-1; i>=0; i--)
     {
         while( !stack.isEmpty() && arr[stack.peek()] < arr[i] )
         {
             int idx = stack.pop();
             nge[idx] = idx - i;
         }
         
         stack.push(i);
     }
     
     while(!stack.isEmpty())
     {
         int idx = stack.pop();
         nge[idx] = idx+1;
     }
     return nge;
 }

}