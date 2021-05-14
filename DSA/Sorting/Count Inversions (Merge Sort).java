class Solution
{
    public static long count;
    static long inversionCount(long arr[], long N)
    {
        count = 0;
        long[] ans = MergeSort(arr, 0, (int)N - 1);
        
        return count;
    }
    
    // Merge Sort function
    public static long[] MergeSort(long[] arr, int lo, int hi)
    {
        if( lo == hi )
        {
            long [] base = {arr[lo]};
            return base;
        }

        int mid = (lo + hi)/2;

        long[] rec1 = MergeSort(arr, lo, mid);
        long[] rec2 = MergeSort(arr, mid + 1, hi);

        return MTSA(rec1, rec2);
    }

    // merge 2 sorted arrays
    public static long[] MTSA(long[] x, long[] y)
    {
        int i=0, j=0, k=0;
        int n = x.length, m = y.length;
        long[] z = new long[n + m];

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
                count += (n - i);
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