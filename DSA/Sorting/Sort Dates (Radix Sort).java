import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    
    int exp = 1;
    // dates
    for(int l=1; l>=0; l--)
    {
        countSort(arr, exp, 10, 0, 2);
        exp *= 10;
    }
    
    exp = 1;
    // months
    for(int l=3; l>=2; l--)
    {
        countSort(arr, exp, 10, 2, 4);
        exp *= 10;
    }
    
    exp = 1;
    // year
    for(int l=7; l>=4; l--)
    {
        countSort(arr, exp, 10, 4, 8);
        exp *= 10;
    }
    
  }

  public static void countSort(String[] arr,int div, int mod, int ith, int jth) {
      int[] freq = new int[10];
      
      for(int i=0; i<arr.length; i++)
        {
            freq[(Integer.parseInt(arr[i].substring(ith, jth)) / div) % mod] += 1;
            // System.out.println(arr[i].substring(ith, jth));
        }
      
      for(int i=1; i<freq.length; i++)
            freq[i] += freq[i-1];
        
      String[] ans = new String[arr.length];
      for(int i = arr.length-1; i>=0; i--)
      {
          int val = (Integer.parseInt(arr[i].substring(ith, jth)) / div) % mod;
          int idx = freq[val] - 1;
          freq[val]--;
          ans[idx] = arr[i];
      }
      
      for(int i=0; i<arr.length; i++)
        arr[i] = ans[i];
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}