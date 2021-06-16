public class CountSetBits {
    public static void main(String[] args) {
        // USING BITWISE OPERATORS ONLY
        System.out.println(countBits(15));
        System.out.println(countBitsFast(15));

        // Inbuilt
        System.out.println(Integer.bitCount(15));

        System.out.println("13 : " + decimalToBinary(13));
    }

    // T(N) => O(number of set bits)
    public static int countBitsFast(int num)
    {
        int ans = 0;
        while( num != 0 )
        {
            num = num & (num-1);
            ans++;
        }

        return ans;
    }

    public static long decimalToBinary(int num)
    {
        int ans = 0;
        int pow = 1;

        while( num > 0 )
        {
            int last_bit = num&1;
            ans += (last_bit * pow);
            pow *= 10;
            num = num >> 1;
        }
        return ans;
    }

    // T(N) => O(log2(n) + 1)
    public static int countBits(int num)
    {
        int ans = 0;
        while( num !=  0 )
        {
            ans += (num & 1) == 1? 1 : 0;
            num = num >> 1;
        }
        return ans;
    }
}
