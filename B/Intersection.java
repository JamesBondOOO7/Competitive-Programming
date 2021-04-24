import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        int min = -1;
        for(int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
            min = Math.max(min, a[i]);
        }

        int max = 100000;
        for(int i=0; i<n; i++)
        {
            b[i] = sc.nextInt();
            max = Math.min(max, b[i]);
        }

        int ANS = max-min;

        if(ANS < 0)
            ANS = 0;

        else
            ANS++;

        System.out.println(ANS);

    }
}