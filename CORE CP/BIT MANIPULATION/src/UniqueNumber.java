public class UniqueNumber {
    public static void main(String[] args) {
        // unique number which occurs only once
        // BITWISE XOR
        int[] arr = {3, 2, 3, 5, 6, 5, 2};
        int ans = 0;
        for(int ele : arr)
            ans = ans ^ ele;

        System.out.println(ans);
    }
}
