public class ReplaceBitsInMByN {
    public static void main(String[] args) {
        // N = 10000000000
        // M = 10101
        // i = 2, j = 6
        // ANS = 10001010100
        // N and M are 32 bit numbers

//        int n = 1024;
//        int m = 21;
//        int i = 2, j = 6;

        displayBinary(1024);
        displayBinary(21);
        System.out.println(replaceBits(1024, 21, 2, 6));
        System.out.println(replaceBits(15, 2, 1, 3));
    }

    public static int replaceBits(int n, int m, int i, int j)
    {
        // zero the area b/w i to j
        int a = -1<<(j+1);  // 11111000000
        int b = (1<<i)-1;   // 00000000111
        int mask = a|b;  // 11111000111

        int p1 = n & mask;  // .....000...
        // ------------- This was clear bits from i to j -------------

        // m = 101
        // how to make => .....101... , where . = 0
        int p2 = m<<(i);   // => 00000101000

        return p1 | p2;
    }

    public static void displayBinary(int num)
    {
        int count = 0;
        String ans = "";
        while(count <= 15)
        {
            ans = (num & 1) + " " + ans;
            num = num>>1;
            count += 1;
        }

        System.out.println(ans);
    }
}
