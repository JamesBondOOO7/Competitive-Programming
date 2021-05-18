import java.util.*;
public class Main {
    public static long MOD = (long)1000000007;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer, HashMap<Integer, Long>> graph = new HashMap<>();
        for(int i=1; i<=n; i++)
        {
            HashMap<Integer, Long> nbrs = new HashMap<>();
            graph.put(i, nbrs);
        }

        for(int i=1; i<n; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            graph.get(u).put(v, w);
            graph.get(v).put(u, w);
        }

        xorDist(graph, n);
    }

    public static void xorDist(HashMap<Integer, HashMap<Integer, Long>> graph, int V)
    {
        // Step 1 : Using BFS, calculate dist(x, i)
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Long> path = new LinkedList<>();
        boolean[] processed = new boolean[V+1];
        long[] dxi = new long[V+1];
        queue.addLast(1);
        path.addLast(0l);
        while( !queue.isEmpty() )
        {
            int rn = queue.removeFirst();
            long psf = path.removeFirst();

            if(processed[rn])
                continue;

            dxi[rn] = psf;
            processed[rn] = true;
            for(Integer nbr : graph.get(rn).keySet())
            {
                queue.addLast(nbr);
                path.addLast( psf ^ graph.get(rn).get(nbr) );
            }
        }

        // for(long dist : dxi)
        //     System.out.println(dist);
        
        long ans = 0l;
        for(int i=0; i<60; i++)  // kth bit concept
        {
            int[] cnt = new int[2];
            for(int j=1; j<=V; j++)
            {
                cnt[(int)(dxi[j]>>i&1)] += 1;
            }
            
            // pairs will only be counted when the bit differ at the ith bit
            // (1l<<i) : It is used to convert them into decimal
            // as our purpose is to calculate the sum of the XOR distances
            // xor is 1 when the bit differs
            // and sum is calculted in decimal
            // at each "ith" point in decimal, we need to multiply by 2^(i)
            // which is equivalent to (1l<<i)
            long temp = ((1l<<i)%MOD)*((long)cnt[0])%MOD*(long)cnt[1];
            ans += temp;
            ans = ans % MOD;
        }
        
        System.out.println(ans);
    }
}