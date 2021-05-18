import java.util.*;
public class Main {
    public static int[][] dp;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();

        char [][] board = new char[h][w];
        for(int i=0; i<h; i++)
        {
            String str = sc.nextLine();
            for(int j=0; j<w; j++)
            {
                board[i][j] = str.charAt(j);
            }
        }

        dp = new int[h][w];
        for(int i=0; i<h; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int res = Optimalgame(board, 0, 0, 0, h, w);

        System.out.println(res == 0? "Draw" : (res > 0 ? "Takahashi" : "Aoki"));
    }

    public static int Optimalgame(char[][] board, int move, int i, int j, int h, int w)
    {
        // Out of grid
        if( i>=h || j>=w )
            return 0;

        if( dp[i][j] != Integer.MAX_VALUE )
            return dp[i][j];

        // Do your best, expect for the worst

        if( move == 0 )  // H's turn
        {
            // things in H's control => do your best
            int res = Integer.MIN_VALUE;

            if( i+1 < h)
            {
                int point = board[i+1][j] == '+' ? 1 : -1;
                res = Math.max(res, Optimalgame(board, 1, i+1, j, h, w) + point);
            }

            if( j+1 < w)
            {
                int point = board[i][j+1] == '+' ? 1 : -1;
                res = Math.max(res, Optimalgame(board, 1, i, j+1, h, w) + point);
            }

            if( res == Integer.MIN_VALUE )
                res = 0;

            dp[i][j] = res;
            return res;
        }

        else  // A's turn
        {

            // things not in H's control => expect the worst
            int res = Integer.MAX_VALUE;

            if( i+1 < h)
            {
                int point = board[i+1][j] == '+' ? -1 : 1;
                res = Math.min(res, Optimalgame(board, 0, i+1, j, h, w) + point);
            }

            if( j+1 < w)
            {
                int point = board[i][j+1] == '+' ? -1 : +1;
                res = Math.min(res, Optimalgame(board, 0, i, j+1, h, w) + point);
            }

            if( res == Integer.MAX_VALUE )
                res = 0;

            dp[i][j] = res;
            return res;
        }
    }
}