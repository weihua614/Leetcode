import java.util.Arrays;

public class setZeroes {
    //https://leetcode.cn/problems/zero-matrix-lcci/
    public void setZeroes(int[][] matrix) {
        boolean FirstNums[]=new boolean[matrix.length];
        boolean SecNums[]=new boolean[matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if (matrix[i][j]==0)
                {
                    FirstNums[i]=true;
                    SecNums[j]=true;
                }
            }
        }
        for (int i=0;i<matrix.length;i++)
        {
            if (FirstNums[i])
            Arrays.fill(matrix[i],0);
        }
        for (int i=0;i<matrix[0].length;i++)
        {
            if (SecNums[i])
            {
                for (int j=0;j<matrix.length;j++)
                {
                    matrix[j][i]=0;
                }
            }
        }

    }
}
