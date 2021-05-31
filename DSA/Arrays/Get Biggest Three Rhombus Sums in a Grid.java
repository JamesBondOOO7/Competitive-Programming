class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++)
        {
            set.add(grid[i][0]);
            set.add(grid[n-i-1][m-1]);
        }
        
        for(int j=0; j<m; j++)
        {
            set.add(grid[0][j]);
            set.add(grid[n-1][j]);
        }
        
        for(int i=1; i<n-1; i++)
        {
            for(int j=1; j<m-1; j++)
            {
                set.add(grid[i][j]);
                
                int w = 1;
                while( true )
                {
                    int area = calArea(grid, i, j, w);
                    if( area != -1 )
                    {
                        set.add(area);
                    }
                    
                    else
                        break;
                    
                    w++;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        
        int [] ans;
        if( list.size() >= 3)
        {
            ans = new int[3];
            for(int i=0; i<3; i++)
            {
                ans[i] = list.get(i);
            }
        }
        else
        {
            ans = new int[list.size()];
            for(int i=0; i<list.size(); i++)
            {
                ans[i] = list.get(i);
            }
        }
        return ans;
    }
    
    public static int calArea(int[][] grid, int i, int j, int w)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        if( i + w >= n || i - w < 0 || j + w >= m || j - w < 0 )
            return -1;
        
        int area = 0;
        
        for(int r = i, c = j-w, count = 1; count <= w ;r--, c++, count++)
            area += grid[r][c];
        
        for(int r = i-w, c = j, count = 1; count <= w ;r++, c++, count++)
            area += grid[r][c];
        
        for(int r = i, c = j+w, count = 1; count <= w ;r++, c--, count++)
            area += grid[r][c];
        
        for(int r = i+w, c = j, count = 1; count <= w ;r--, c--, count++)
            area += grid[r][c];
        
        return area;
    }
}