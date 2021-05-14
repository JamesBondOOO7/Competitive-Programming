public class Main {
    public static void main(String[] args) {
        // Counting Sort
        int[] arr = {9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9};
        int n = arr.length;
        // Step 1 : min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int ele : arr)
        {
            min = Math.min(ele, min);
            max = Math.max(ele, max);
        }
        
        // Step 2 : array of length (max - min + 1)
        int[] freq = new int[max - min + 1];
        
        // Step 3 : update frequencies
        for(int ele : arr)
            freq[ele - min]++;
        
        // Step 4 : make it cummulative freq
        for(int i=1; i<freq.length; i++)
            freq[i] += freq[i-1];
        
        // Step 5 : update the original array from last
        // so that the sort remains STABLE
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            int ele = arr[i];
            int freq_idx = freq[ele - min] - 1;
            ans[freq_idx] = ele;
            freq[ele - min]--;
        }
        
        for(int ele : ans)
            System.out.print(ele + " ");
    }
}