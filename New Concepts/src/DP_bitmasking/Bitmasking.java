package DP_bitmasking;

public class Bitmasking {
    public static void main(String[] args) {
        // the set contains {1, 2, 3, 4}
        int set = 15;

        display(set);

        // remove an element
        display(remove(set, 2));

        // add an element
        display(add(set, 5));
    }

    public static void display(int set)
    {
        for(int bit_no=0; bit_no<=9; bit_no++)
        {
            if( (set & (1 << bit_no)) != 0 )
                System.out.print((bit_no + 1) + " ");
        }
        System.out.println();
    }

    public static int remove(int set, int element)
    {
        // set is 000...01111
        // xor with a 1 at that index to remove the element
        // note : we should also check whether the element is present or not

        if( (set & (1 << element-1 )) == 0)  // i.e the bit is off for that element
            return set;

        // if it is on, then off it using xor and return it
        set = (set ^ ( 1 << element-1 ));
        return set;
    }

    public static int add(int set, int element)
    {
        if( (set & (1 << element-1 )) == 1)  // i.e the bit is already on for that element
            return set;

        // if it is on, then on it using xor and return it
        set = (set ^ ( 1 << element-1 ));
        return set;
    }
}
