import  java.util.*;
public class Main {
    static class Node
    {
        int north;
        int south;

        Node(int north, int south)
        {
            this.north = north;
            this.south = south;
        }
    }
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Node> bridges = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int N = sc.nextInt();
            int S = sc.nextInt();

            Node nn = new Node(N, S);
            bridges.add(nn);
        }

        System.out.println(BuildNonOverlappingBridges(bridges));
        System.out.println(optimized(bridges));
    }

    public static int BuildNonOverlappingBridges(ArrayList<Node> bridges)
    {
        // Steps Involved
        // 1. Sort on the basis of 1 dir ( say north )
        // 2. Now find LIS on the south side while traversing on the North side !!
        // But Why?
        // suppose while traversing we encounter a pair : b[i] and b[j]
        // b[i].north > b[j].north ; always because it is sorted
        // thus we only need to check for the south direction
        // if they will not overlap if and only if b[i].south > b[j].south
        // Notice that this is what we do in LIS

        Collections.sort(bridges, new Comparator<Node>(){
            public int compare(Node n1, Node n2)
            {
                return n1.north - n2.north;
            }
        });

        int [] dp = new int[bridges.size()];
        Arrays.fill(dp, 1);
        int ans = 1;

        // Note : We will not be using optimized LIS
        for(int i=1; i<bridges.size(); i++)
        {
            Node curr = bridges.get(i);
            for(int j=0; j<i; j++)
            {
                Node prev = bridges.get(j);

                if (prev.south < curr.south)
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int optimized(ArrayList<Node> bridges)
    {
        Collections.sort(bridges, new Comparator<Node>(){
            public int compare(Node n1, Node n2)
            {
                return n1.north - n2.north;
            }
        });

        int[] dp = new int[bridges.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=0; i<bridges.size(); i++)
        {
            Node nn = bridges.get(i);

            int pos = binarySearch(dp, nn.south, i);
            dp[pos] = nn.south;

            // System.out.print(nn.south + " : ");
            // for(int ele : dp)        
            // {
            //     if( ele != Integer.MAX_VALUE )
            //         System.out.print(ele + " ");

            //     else
            //         System.out.print("INF ");
            // }

            // System.out.println();
        }

        for(int i = dp.length - 1;i >= 0;i--)
        {
            if(dp[i] != Integer.MAX_VALUE)
                return i + 1;
        }

        return 1;
    }

    public static int binarySearch(int[] dp, int target, int hi)
    {
        int lo = 0;

        while( lo <= hi )
        {
            int mid = lo + (hi - lo)/2;

            if( dp[mid] == target )
                return mid;

            else if( dp[mid] < target )
                lo = mid + 1;

            else
                hi = mid - 1;
        }

        return lo;
    }
}