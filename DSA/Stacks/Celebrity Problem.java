import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++)
        {
            stack.push(i);
        }
        
        while( stack.size() != 1 )
        {
            int v1 = stack.pop();
            int v2 = stack.pop();
            
            if(arr[v1][v2] == 1)
            {
                stack.push(v2);
            }
            else
            {
                stack.push(v1);
            }
        }
        
        int ans = stack.pop();
        boolean found = true;
        
        // check the row
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[ans][i] == 1)
            {
                found = false;
                break;
            }
        }
        if(!found)
        {
            System.out.println("none");
            return;
        }
        
        // check the col
        for(int i = 0; i<arr.length; i++)
        {
            if( i!=ans && arr[i][ans] == 0)
            {
                found = false;
                break;
            }
        }
        
        if(found)
            System.out.println(ans);
            
        else
            System.out.println("none");
    }

}