import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class DivisibleSubset {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while( t-->0 )
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }

            DivSubset(arr, n);
        }
    }

    static class Node
    {
        int ei;
        long sum;
        Node(int ei, long sum)
        {
            this.ei = ei;
            this.sum = sum;
        }
    }
    public static void DivSubset(int[] arr, int n)
    {
        Node[] cumm = new Node[n+1];
        cumm[0] = new Node(0, 0);

        for(int i=1; i< n+1; i++)
        {
            Node nn = new Node(i, cumm[i-1].sum + arr[i-1]);
            cumm[i] = nn;
        }

        HashMap<Long, Node> map = new HashMap<>();
        for (int i = 0; i < n+1; i++)
        {
            cumm[i].sum = (((cumm[i].sum % n) + n ) % n);
            if( map.containsKey(cumm[i].sum) )
            {
                int si = map.get(cumm[i].sum).ei;
                int ei = cumm[i].ei;

                System.out.println(ei - si);;
                for (int j = si + 1; j <=ei ; j++)
                {
                    System.out.print(j + " ");
                }
                break;
            }
            else
            {
                map.put(cumm[i].sum, cumm[i]);
            }
        }

    }
}