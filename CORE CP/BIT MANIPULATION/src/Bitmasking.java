public class Bitmasking {
    public static void main(String[] args) {
        oddOrEven(2);
        oddOrEven(7);

        System.out.println(ithBit(5, 0));
        System.out.println(ithBit(5, 1));
        System.out.println(ithBit(5, 2));
        System.out.println(ithBit(5, 3));

        System.out.println(setithBit(5, 1));

        System.out.println(clearithBit(5, 2));

        System.out.println(updateBit(5, 2, 0));
        System.out.println(updateBit(1, 3, 1));

        System.out.println(clearLastiBits(15, 3));

        System.out.println(clearRangeiToj(31, 1, 3));
    }

    public static void oddOrEven(int num)
    {
        if( (num & 1) == 1 )
            System.out.println("Odd");

        else
            System.out.println("Even");
    }

    public static int ithBit(int num, int i)
    {
        int mask = 1<<i;
        return (num & mask) > 0 ? 1 : 0;
    }

    public static int setithBit(int num, int i)
    {
        int mask = 1<<i;
        return (num | mask);
    }

    public static int clearithBit(int num, int i)
    {
        // set ith bit to 0

        int mask = 1<<i;  // 00000001000
        // flip the mask  // 11111110111
        mask = ~mask;

        return (mask & num);
    }

    public static int updateBit(int num, int i, int v)
    {
        // set ith bit as v (either 0 or 1)

        // set ith bit to 0
        int mask = ~(1<<i);
        int cleared_num = num & mask;

        // set ith bit to v
        num = cleared_num | (v<<i);
        return num;
    }

    public static int clearLastiBits(int num, int i)
    {
        // num => 1011011010 and i = 4
        // ans => 1011010000

        // ~0 = -1 = -- all 1s --
        int mask = (-1<<i);
        return (num & mask);
    }

    public static int clearRangeiToj(int num, int i, int j)
    {
        // 0011111, i=1, j=3
        // => 0010001

        // How to create the mask
        // We need something like : 1111110000111
        // part 1 : 1111110000000 ( jth position to end we have 0 )
        // part 2 : 0000000000011 ( (i + 1) th position to end we have 1 )
        // mask = part 1 OR part 2

        int part1 = -1<<(j+1);
        int part2 = (1<<i) - 1;  // 000..01111 is nothing but 2^i - 1

        int mask = part1 | part2;

        return (num & mask);
    }
}
