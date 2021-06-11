class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        if( k>0 && k <= r - l + 1 )
        {
            int pos = partition(arr, l, r);
            
            if( pos - l == k - 1 )
                return arr[pos];
                
            else if( pos - l > k - 1 )
                return kthSmallest(arr, l, pos-1, k);
                
            else
                return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }
        
        return Integer.MAX_VALUE;
    }
    
    public static int partition(int[] arr, int l, int r)
    {
        int mid = (l + r)/2;
        int pivot = arr[mid];
        // swap last element and make it pivot
        int temp = arr[mid];
        arr[mid] = arr[r];
        arr[r] = temp;
        
        int i = l;
        
        for(int j=l; j<=r-1; j++)
        {
            if(arr[j] <= pivot)
            {
                // swap
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
            }
        }
        
        // swapping arr[i] and arr[r] ( the pivot )
        temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        
        return i;
    }
}
