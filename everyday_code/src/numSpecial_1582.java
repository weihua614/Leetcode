public class numSpecial_1582 {
    public int numSpecial(int[][] mat) {
        int result=0;
        for (int i=0;i<mat.length;i++) {
            int num = 0;
            int index = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    index = j;
                    num++;
                    if (num > 1) break;
                }
            }
            System.out.println(num);
            if(num==1)
            {
                for (int k = 0; k < mat.length; k++)
                {
                    if(mat[k][index]==1)
                    {
                        num++;
                    }
                    if(num>2) break;
                }
                if(num==2)
                result++;
            }
        }
        return result;
    }
}
