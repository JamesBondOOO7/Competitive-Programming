import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] players = new int[n][5];

        for(int i=0; i<n; i++)
        {
            for(int j = 0; j<5; j++)
                players[i][j] = sc.nextInt();
        }

        int lo = 0;
        int hi = 1000000000;
        int ans = 0;

        while( lo<=hi )
        {
            int mid = (lo + hi)/2;
            // System.out.println(mid);
            if( ok(players, mid) )
            {
                lo = mid + 1;
                ans = mid;
            }
            else
                hi = mid - 1;
        }

        System.out.println(ans);
    }

    public static boolean ok(int[][] players, int mid)
    {
        HashSet<Integer> set = new HashSet<>();

        // Crux :
        // For each player, we will check his abilities
        // if his ability >= mid, then that ability is useful
        // for each player, we have _,_,_,_,_
        // So, if so, 0th and 3rd ability satisfy
        // => 1,_,_,1,_
        // => c = 0 | 1<<1 | 1<<3

        // for some other player
        // c = 0 | 1 << 2 | 1 << 3

        // and for the 3rd
        // c = 0 | 1<<1 | 1<<4

        // but if we combine these 3 players
        // c = 0 | 1<<0 | 1<<1 | 1<<2 | 1<<3 | 1<<4 = 31
        // Thus, the min of all max powers will be mid !!

        // SO COOL APPLICATION OF BINARY SEARCH !!

        for(int[] player : players)
        {
            int c = 0;
            for(int i = 0; i<5; i++ )
            {
                int strength = player[i];
                if( strength >= mid )
                    c = c | ( 1 << i );
            }
            set.add(c);
        }

        // Set is used to avoid repetition of similar players
        for(Integer p1 : set)
        {
            for(Integer p2 : set)
                {
                    for(Integer p3 : set)
                    {
                        if ( (p1 | p2 | p3) == 31 )
                            return true;
                    }
                }
        }

        return false;
    }
}