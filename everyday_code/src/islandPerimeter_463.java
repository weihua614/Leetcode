public class islandPerimeter_463 {
    public int islandPerimeter(int[][] grid)
    {
        int result=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]==1)
                {
                    int nums=4;
                    if (i-1>=0)
                    {
                        if (grid[i-1][j]==1)
                            nums--;
                    }
                    if (i+1<grid.length)
                    {
                        if (grid[i+1][j]==1)
                            nums--;
                    }
                    if (j-1>=0)
                    {
                        if (grid[i][j-1]==1)
                            nums--;
                    }
                    if (j+1<grid[0].length)
                    {
                        if (grid[i][j+1]==1)
                            nums--;
                    }
                    result+=nums;
                }
            }
        }
        return result;
    }

}
