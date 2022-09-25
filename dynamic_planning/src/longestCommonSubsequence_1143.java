import org.junit.Test;//44

public class longestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2)
    {
        int result[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++)
        {
            for (int j=1;j<text2.length()+1;j++)
            {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                {
                    result[i][j]=Math.max(Math.max(result[i-1][j],result[i][j-1]),result[i-1][j-1]+1);
                }
                else
                {
                    result[i][j]=Math.max(result[i-1][j],result[i][j-1]);
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        return result[text1.length()][text2.length()];
    }


    @Test
    public void test()
    {
        System.out.println(longestCommonSubsequence("abcasdsadsadaba", "abcasdadadwbcba"));
    }
}
