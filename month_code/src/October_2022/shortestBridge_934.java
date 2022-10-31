package October_2022;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashSet;

public class shortestBridge_934 {
    /**
     *  [1,1,1,1,1],
     *  [1,0,0,0,1],
     *  [1,0,1,0,1],
     *  [1,0,0,0,1],
     *  [1,1,1,1,1]]
     *
     *  [0,1,0,0,0],
     *  [0,1,0,1,1],
     *  [0,0,0,0,1],
     *  [0,0,0,0,0],
     *  [0,0,0,0,0]]
     *
     *  [1,1,0,0,0],
     *  [1,0,0,0,0],
     *  [1,0,0,0,0],
     *  [0,0,0,1,1],
     *  [0,0,0,1,1]]
     */

    HashSet<Pair<Integer,Integer>> island=new HashSet<>();
    public int shortestBridge(int[][] grid) {
        boolean flag1=false;
        for (int i=0;i<grid.length;i++)
        {
            if (flag1) break;
            for (int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j]==1)
                {
                    recall(grid,i,j);
                    flag1=true;
                    break;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (Pair<Integer,Integer> i:island)
        {
            min=Math.min(min,countPath(grid,i.getKey()+1,i.getValue(),new boolean[grid.length][grid[0].length]));

            min=Math.min(min,countPath(grid,i.getKey()-1,i.getValue(),new boolean[grid.length][grid[0].length]));
            min=Math.min(min,countPath(grid,i.getKey(),i.getValue()+1,new boolean[grid.length][grid[0].length]));
            min=Math.min(min,countPath(grid,i.getKey(),i.getValue()-1,new boolean[grid.length][grid[0].length]));
        }
        return min;
    }
    public void recall(int[][]grid,int left,int right)
    {
        if (left<0||left>=grid.length||right<0||right>=grid[0].length)
        {
            return ;
        }
        if (grid[left][right]!=1) return;
        Pair<Integer, Integer> pair = new Pair<>(left, right);
        if (island.contains(pair)) return;
        island.add(pair);
        recall(grid,left-1,right);
        recall(grid,left+1,right);
        recall(grid,left,right-1);
        recall(grid,left,right+1);
    }
    public int countPath(int[][]grid,int left,int right,boolean[][]flag)
    {
        Pair<Integer, Integer> pair = new Pair<>(left, right);
        if (left<0||left>=grid.length||right<0||right>=grid[0].length||flag[left][right]||island.contains(pair))
        {
            return Integer.MAX_VALUE/2;
        }
        if (grid[left][right]==1) return 0;
        flag[left][right]=true;
        int temp1=countPath(grid,left-1,right,flag)+1;
        int temp2=countPath(grid,left+1,right,flag)+1;
        int temp3=countPath(grid,left,right-1,flag)+1;
        int temp4=countPath(grid,left,right+1,flag)+1;
        flag[left][right]=false;
        int min1=Math.min(temp1,temp2);
        int min2=Math.min(temp3,temp4);
        return Math.min(min1,min2);
    }

    @Test
    public void test()
    {
        System.out.println(shortestBridge(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}}));
    }




}
