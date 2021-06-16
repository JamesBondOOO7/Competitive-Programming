import java.io.*;
import java.util.*;

public class Main {

  public static void sort012(int[] arr){
    
    int curr = 0, left = 0, right = arr.length - 1;
    while( curr <= right )
    {
        if( arr[curr] == 0 )
        {
            swap(arr, curr, left);
            left++;
            curr++;
        }
        else if( arr[curr] == 1 )
        {
            curr++;
        }
        else
        {
            swap(arr, curr, right);
            right--;
        }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}