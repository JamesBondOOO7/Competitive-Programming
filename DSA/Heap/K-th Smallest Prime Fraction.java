class Solution {
    
    static class Node
    {
        int p;
        int q;
        
        Node(int p, int q)
        {
            this.p = p;
            this.q = q;
        }
    }
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>(){
            
            public int compare(Node a, Node b)
            {
                return b.p * a.q - a.p * b.q;
            }
        });
        
        for(int i=0; i<arr.length-1; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                Node nn = new Node(arr[i], arr[j]);
                
                if( heap.size() < k )
                    heap.add(nn);
                
                else
                {
                    Node tn = heap.peek();
                    
                    if( tn.p * nn.q > nn.p * tn.q )
                    {
                        heap.remove();
                        heap.add(nn);
                    }
                }
            }
        }
        
        return new int[] { heap.peek().p, heap.peek().q };
    }
}