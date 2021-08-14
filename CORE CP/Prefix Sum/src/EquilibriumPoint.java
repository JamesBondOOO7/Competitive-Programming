
import java.io.*;
//import java.util.*;

class EquilibriumPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();

            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }

    static class Solution {

        // a: input array
        // n: size of array
        // Function to find equilibrium point in the array.
        public static int equilibriumPoint(long a[], int n) {
            if( n == 1 )
                return 1;

            long x = 0;
            int l = 0, r = n-1;

            while( l<r )
            {
                while(x<=0 && l<r)
                {
                    x += a[l];
                    l++;
                }

                while( x>=0 && l<r)
                {
                    x -= a[r];
                    r--;
                }
            }

            if (x == 0)
                return l+1;

            return -1;
        }
    }
}