import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double r1 = -1;
        for(int i=0; i<n; i++)
            r1 = Math.max(r1, sc.nextDouble());

        int m = sc.nextInt();
        double p1 =-1;
        int[] y = new int[m];
        for(int i = 0; i<m; i++)
            p1 = Math.max(p1, sc.nextDouble());

        int k = sc.nextInt();
        double p2 = 5001.00;
        int[] z = new int[k];
        for(int i=0; i<k; i++)
            p2 = Math.min(p2, sc.nextDouble());

        double A = sc.nextDouble();
        double B = sc.nextDouble();

        double r2 = Math.pow( (r1*r1)/( 1 + (A*p2)/(B*p1) ) , 0.5 );

        System.out.println(r2);
    }
}