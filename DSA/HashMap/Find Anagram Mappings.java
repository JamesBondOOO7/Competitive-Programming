public class Solution {
    
    public int[] anagramMappings(int[] arr1, int[] arr2) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		for(int i=0; i<arr2.length; i++)
		{
		    if( map.containsKey(arr2[i]))
		        map.get(arr2[i]).addLast(i);
		        
		    else
		    {
		        LinkedList<Integer> list = new LinkedList<>();
		        list.addLast(i);
		        map.put(arr2[i], list);
		    }
		    
		}
		
		int[] ans = new int[arr1.length];
		
		for(int i=0; i<arr1.length; i++)
		    ans[i] = map.get(arr1[i]).removeFirst();
		    
		return ans;
    }
}