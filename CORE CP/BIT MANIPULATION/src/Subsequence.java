public class Subsequence {
    public static void main(String[] args) {
        // Print all the subsequences/subsets of the strings

        String str = "abc";
        CreateSubsequence(str);
    }

    public static void CreateSubsequence(String str)
    {
        for(int i=0; i<(1<<(str.length())); i++)
        {
            printSubsequence(str, i);
        }
    }

    public static void printSubsequence(String str, int n)
    {
        if( n == 0 )
        {
            System.out.println("-- Empty --");
            return;
        }
        int j=0;
        while( n != 0 )
        {
            if( (n&1) == 1 )
            {
                // means print that character
                System.out.print(str.charAt(j));
            }
            j++;
            n = n>>1;
        }
        System.out.println();
    }
}
