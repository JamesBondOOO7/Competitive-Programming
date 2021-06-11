import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
            
        int fee = sc.nextInt();
        
        int bsp = -arr[0];
        int ssp = 0;
        
        for(int i=1; i<n; i++)
        {
            // System.out.println(bsp + " -- " + ssp);
            
            int nbsp = Math.max(bsp, ssp - arr[i]);
            int nssp = Math.max(ssp, arr[i] + bsp - fee);
            
            bsp = nbsp;
            ssp = nssp;
        }
        
        System.out.println(ssp);
    }

}