import java.util.Arrays;

public class minDistance_72 {
    /*
    word1 = "intention", word2 = "execution"
             012345678            012345678
             etion 4               etion4
     */
    public int minDistance(String word1, String word2) {
        int length1=word1.length();
        int length2=word2.length();
        char []word1Char=word1.toCharArray();
        char []word2Char=word2.toCharArray();
        int result[][]=new int[length1+1][length2+1];
        for (int i=1;i<=length1;i++)
        {
            result[i][0]=i;
        }
        for (int i=1;i<=length2;i++)
        {
            result[0][i]=i;
        }
        for (int i=1;i<=length1;i++)
        {
            for (int j=1;j<=length2;j++)
            {
                result[i][j]=Integer.MAX_VALUE;
                if (word1Char[i-1]==word2Char[j-1])
                {
                    result[i][j]=result[i-1][j-1];
                }
                else
                {
                    result[i][j]=Math.min(result[i][j],result[i][j-1]+1);
                    result[i][j]=Math.min(result[i][j],result[i-1][j]+1);
                    result[i][j]=Math.min(result[i][j],result[i-1][j-1]+1);
                }
              //  System.out.print(result[i][j]);
            }
           // System.out.println();
        }
        return result[length1][length2];
    }
}
