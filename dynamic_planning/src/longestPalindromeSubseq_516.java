import org.junit.Test;

public class longestPalindromeSubseq_516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int result[][]=new int[length][length];
        for (int i=0;i<length;i++)
        {
            result[i][i]=1;
            for (int j=i-1;j>=0;j--)
            {
                if (chars[i]==chars[j])
                {
                    if (i-1==j) result[i][j]=2;
                    else
                    {
                        result[i][j]=result[i-1][j+1]+2;
                    }
                }
                else
                {
                    result[i][j]=Math.max(result[i-1][j],result[i][j+1]);
                }
            }
        }
        for (int[]a:result)
        {
            for (int b:a)
                System.out.print(b+",");
            System.out.println();
        }
        return result[length-1][0];
    }
    @Test
    public void test()
    {
        char[]a=new char[]{'a','b','a'};
        System.out.println(longestPalindromeSubseq("cbbdsadawadsad"));
    }
}
