import java.util.*;
public class Main {
    public static LinkedList<Integer> B;
    public static LinkedList<Integer> C;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt() % 200;
        }

        B = new LinkedList<>();
        C = new LinkedList<>();

        boolean ans = modulo(arr, 0, 0, 0, true);

        if ( ans )
        {
            System.out.println("YES");
            System.out.print(B.size() + " ");
            for( Integer ele : B )
                System.out.print(ele + " ");

            System.out.println();
            System.out.print(C.size() + " ");
            for( Integer ele : C )
                System.out.print(ele + " ");
        }

        else
            System.out.println("NO");
    }

    public static boolean modulo(int[] A, long bsum, long csum, int ci, boolean Same)
    {
        if ( !Same && (bsum != 0  && csum != 0) && ( bsum%200 == csum%200 ) )
        {
            // System.out.println(bsum + " -- " + csum);
            return true;
        }

        if ( ci == A.length )
            return false;

        // not ci
        if( modulo(A, bsum, csum, ci + 1, Same) )
            return true;

        // ci in B
        B.addLast(ci + 1);
        if( modulo(A, bsum + A[ci], csum, ci + 1, false) )
            return true;

        B.removeLast();

        // ci in C
        C.addLast(ci + 1);
        if( modulo(A, bsum, csum + A[ci], ci + 1, false) )
            return true;

        // ci in both B and C
        B.addLast(ci + 1);
        if( modulo(A, bsum + A[ci], csum + A[ci], ci + 1, Same) )
            return true;

        C.removeLast();
        B.removeLast();
        return false;
    }
}