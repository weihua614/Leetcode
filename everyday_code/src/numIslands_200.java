import javafx.util.Pair;

import java.util.HashMap;

public class numIslands_200 {
    public int numIslands(char[][] grid) {
        int nums=0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]!='2'&&grid[i][j]!='0')
                {
                    nums++;
                    recall(grid,i,j);
                }
            }
        }
        return nums;
    }
    public void recall(char[][]grid,int left,int right)
    {
        if (left>=grid.length||right>=grid[0].length||left<0||right<0)return;
        if (grid[left][right]=='0'||grid[left][right]=='2') return;
        grid[left][right]='2';
        recall(grid,left-1,right);
        recall(grid,left,right-1);
        recall(grid,left+1,right);
        recall(grid,left,right+1);
    }
}
