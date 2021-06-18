import java.math.BigInteger;
public class BigIntegersInJava {
    public static void main(String[] args) {
        playWithBigInteger();
        System.out.println(fact(100));
    }

    public static BigInteger fact(int num)
    {
        BigInteger b = new BigInteger("1");
        for(int i=2; i<=num; i++)
        {
            b = b.multiply(BigInteger.valueOf(i));
        }
        return b;
    }

    public static void playWithBigInteger()
    {
        BigInteger b1 = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("122222222525353539999999999999999");

        // adding
        b1 = b1.add(b2);
        System.out.println(b1);

        // multiplying
        b2 = b2.multiply(b1);
        System.out.println(b2);

        // Bit Counts : total set bits
        System.out.println(b1.bitCount());

        // Bit length : total number of bits
        System.out.println(b1.bitLength());

        // Integer to Big Integer
        int a = 15;
        int b = 25;

        BigInteger b3 = BigInteger.valueOf(a);
        BigInteger b4 = BigInteger.valueOf(b);

        // GCD of 2 numbers
        System.out.println(b3.gcd(b4));

        // Base Conversion
        // It interprets the number with base/radix 2
        BigInteger b5 = new BigInteger("1010", 2);
        // 1010 is a binary number converted to decimal
        System.out.println(b5);

        // power
        // the power should be Integer
        System.out.println(b3.pow(20));
    }
}
