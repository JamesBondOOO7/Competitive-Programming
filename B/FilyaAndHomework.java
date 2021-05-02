import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++)
            set.add(sc.nextInt());

        if( set.size() < 3 )
            System.out.println("YES");

        else if (set.size() > 3)
            System.out.println("NO");

        else
        {
            int[] arr = new int[3];
            int i = 0;
            for(Integer ele : set)
            {
                arr[i] = ele;
                i++;
            }

            Arrays.sort(arr);

            if (arr[0] + arr[2] == 2*arr[1])
                System.out.println("YES");
            
            else
                System.out.println("NO");
        }
    }
}