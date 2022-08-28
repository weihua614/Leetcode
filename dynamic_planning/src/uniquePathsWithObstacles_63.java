public class uniquePathsWithObstacles_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int wide=obstacleGrid.length;
        int length=obstacleGrid[0].length;
        if(obstacleGrid[wide-1][length-1]==1||obstacleGrid[0][0]==1) return 0;
        int[][] result = new int[wide][length];
        result[0][0]=1;
        for(int i=1;i<wide;i++)
        {
            if(obstacleGrid[i][0]==0)
                result[i][0]=result[i-1][0];
        }
        for(int i=1;i<length;i++)
        {
            if(obstacleGrid[0][i]==0)
                result[0][i]=result[0][i-1];
        }
        for(int i=1;i<wide;i++)
        {
            for(int j=1;j<length;j++)
            {
                if(obstacleGrid[i][j]==1) result[i][j]=0;
//                else if(obstacleGrid[i-1][j]==1)
//                    result[i][j]=result[i][j-1];
//                else if(obstacleGrid[i][j-1]==1)
//                    result[i][j]=result[i-1][j];
                else
                result[i][j]=result[i-1][j]+result[i][j-1];
            }
        }
        for (int[]a:result)
        {
            for(int b:a)
                System.out.print(b);
            System.out.println();
        }
        return result[wide-1][length-1];
    }

    public static void main(String[] args) {
        uniquePathsWithObstacles_63 aa = new uniquePathsWithObstacles_63();
        int [][]v=new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(aa.uniquePathsWithObstacles(v));
    }
}
