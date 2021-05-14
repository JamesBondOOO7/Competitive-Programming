public class Main {
    public static void main(String args[]) {
        // Merge Sort
        int[] arr = {-10, 6, 3, 1, 7, 4, 3, 19, 16, 4, 6, -5, 8, 2, -7};
        int n = arr.length;

        int[] ans = MergeSort(arr, 0, n-1);
        for(int ele : ans)
            System.out.print(ele + " ");

        System.out.println();
    }

    // Merge Sort function
    public static int[] MergeSort(int[] arr, int lo, int hi)
    {
        if( lo == hi )
        {
            int [] base = {arr[lo]};
            return base;
        }

        int mid = (lo + hi)/2;

        int[] rec1 = MergeSort(arr, lo, mid);
        int[] rec2 = MergeSort(arr, mid + 1, hi);

        return MTSA(rec1, rec2);
    }

    // merge 2 sorted arrays
    public static int[] MTSA(int[] x, int[] y)
    {
        int i=0, j=0, k=0;
        int n = x.length, m = y.length;
        int[] z = new int[n + m];

        while( i<n && j<m )
        {
            if( x[i] <= y[j] )
            {
                z[k] = x[i];
                i++;
            }
            else
            {
                z[k] = y[j];
                j++;
            }

            k++;
        }

        if( i == n )
        {
            while( j<m )
            {
                z[k] = y[j];
                j++;
                k++;
            }
        }

        if( j == m )
        {
            while( i<n )
            {
                z[k] = x[i];
                i++;
                k++;
            }
        }

        return z;
    }
}