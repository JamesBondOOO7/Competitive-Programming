import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
      int max = Integer.MIN_VALUE;
      for(int ele : arr )
        max = Math.max(ele, max);
       
      int exp = 1; 
      while( max != 0 )
      {
          countSort(arr, exp);
          max = max/10;
          exp *= 10;
      }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    
    int[] freq = new int[10];
      
      for(int i=0; i<arr.length; i++)
        freq[(arr[i] / exp) % 10] += 1;
      
    //   freq[0]--;
      for(int i=1; i<freq.length; i++)
            freq[i] += freq[i-1];
        
      int[] ans = new int[arr.length];
      for(int i = arr.length-1; i>=0; i--)
      {
          int val = (arr[i] / exp) % 10;
          int idx = freq[val] - 1;
          freq[val]--;
          ans[idx] = arr[i];
      }
      
      for(int i=0; i<arr.length; i++)
        arr[i] = ans[i];
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}