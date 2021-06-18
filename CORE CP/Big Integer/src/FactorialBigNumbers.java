public class FactorialBigNumbers {
    public static int digits;
    public static void main(String[] args) {
        int n = 100;
        big_factorial(n);
    }

    public static void big_factorial(int num)
    {
        int[] arr = new int[1000];  // store upto 1000 digits

        arr[0] = 1;  // 1! = 1
        digits = 1;  // stores the number of digits
        for(int i=2; i<=num; i++)
        {
            // Note that the product is stored in the array in the reversed order
            multiply(arr, i);
        }

        for (int i = digits-1; i >= 0 ; i--)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void multiply(int[] arr, int num)
    {
        // arr : storing the result
        // digits : current number of digits in the array
        // num : the number to be multiplied

        int carry = 0;
        for(int i=0; i<digits; i++)
        {
            int prod = arr[i]*num + carry;
            arr[i] = prod%10;
            carry = prod/10;
        }

        // the carry is transferred
        while(carry != 0)
        {
            arr[digits] = carry % 10;
            carry = carry / 10;
            digits++;
        }
    }
}
