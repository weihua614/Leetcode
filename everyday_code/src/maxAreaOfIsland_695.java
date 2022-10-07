public class maxAreaOfIsland_695 {
    int nums=0;
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]==0||grid[i][j]==2) continue;
                areaGrid(grid,i,j);
                max=Math.max(max,nums);
                nums=0;
            }
        }
        return max;
    }
    public void areaGrid(int[][]grid,int left,int right)
    {
        if (left<0||right<0||left>=grid.length||right>=grid[0].length)
        {
            return ;
        }
        if (grid[left][right]==0||grid[left][right]==2) return;
        if (grid[left][right]==1) nums++;
        grid[left][right]=2;
        areaGrid(grid,left-1,right);
        areaGrid(grid,left,right-1);
        areaGrid(grid,left+1,right);
        areaGrid(grid,left,right+1);
    }
}
