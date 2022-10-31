package October_2022;

import org.junit.Test;

public class isMatch_10 {
    public boolean isMatch(String s, String p) {
        char c = s.charAt(0);
        for (int i=0;i<p.length();i++)
        {
            if (c==p.charAt(i)||p.charAt(i)=='*'||p.charAt(i)=='.')
            {
                for (int j=i;j<p.length();j++)
                {
                    if (isMatch1(s,p.substring(i,j+1)))
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean isMatch1(String s, String p) {
        boolean result[][]=new boolean[s.length()+1][p.length()+1];
        result[0][0]=true;
        for (int i=1;i<=p.length();i++)
        {
            if (p.charAt(i-1)=='*')
            {
                result[0][i]=true;
            }
            else break;
        }
        for (int i=1;i<=s.length();i++)
        {
            for (int j=1;j<=p.length();j++)
            {
                if (p.charAt(j-1)=='.')
                {
                    result[i][j]=result[i-1][j-1];
                }
                else if (p.charAt(j-1)!='*')
                {
                    if (s.charAt(i-1)==p.charAt(j-1))
                    {
                        result[i][j]=result[i-1][j-1];
                    }
                    else
                    result[i][j]=false;
                }
                else
                {
                    result[i][j]=result[i][j-2];
                }
            }
        }
        return result[s.length()][p.length()];
    }
    @Test
    public void test(){
        isMatch("aab","c*a*b");
    }
}
