import org.junit.Test;

public class maximalSquare_221 {
    public int maximalSquare1(char[][] matrix) {
        int max=0;
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                if (matrix[i][j]!='0')
                {
                    int temp=max+1;
                    while (sSquare(matrix,i,j,temp))
                    {
                        temp++;
                    }
                    max=Math.max(max,temp-1);
                }
            }
        }
        return max;
    }
    public boolean sSquare(char[][] matrix,int left,int right,int num)
    {
        num=num-1;
        if (left+num>=matrix.length) return false;
        if (right+num>=matrix[0].length) return false;
        for (int i=left;i<=left+num;i++)
        {
            for (int j=right;j<=right+num;j++)
            {
                if (matrix[i][j]=='0') return false;
            }
        }
        return true;
    }


    public int maximalSquare(char[][] matrix) {
        int result[][]=new int[matrix.length+1][matrix[0].length+1];
        int max=0;
        for (int i=1;i<=matrix.length;i++)
        {
            for (int j=1;j<=matrix[0].length;j++)
            {
                if (matrix[i-1][j-1]=='0')
                {
                    result[i][j]=0;
                }
                else
                {
                    result[i][j]=Math.min(Math.min(result[i-1][j],result[i][j-1]),result[i-1][j-1])+1;
                    max=Math.max(result[i][j],max);
                }
            }
        }
        return max*max;
    }
    @Test
    public void test()
    {
        maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','0','1'}});
    }
}
