import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t > 0 )
        {
            int n = sc.nextInt();
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                int ele = sc.nextInt();
                if( ele%2 == 0 )
                    even.add(ele);

                else
                    odd.add(ele);
            }

            for(int ele : odd )
                System.out.print(ele + " ");

            for(int ele : even )
                System.out.print(ele + " ");

            System.out.println();
            t--;
        }
    }
}