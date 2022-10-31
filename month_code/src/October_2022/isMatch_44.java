package October_2022;

import org.junit.Test;

public class isMatch_44 {
    public boolean isMatch(String s, String p) {
        int length1=s.length();
        int length2=p.length();
        boolean[][]result=new boolean[length1+1][length2+1];
        result[0][0]=true;

        for (int i=1;i<=length2;i++)
        {
            if (p.charAt(i-1)=='*')
            {
                result[0][i]=result[0][i-1];
            }
        }
        for (int i=1;i<=length1;i++)
            {
                for (int j=1;j<=length2;j++)
                {
                    if (p.charAt(j-1)=='?')
                    {
                        result[i][j]=result[i-1][j-1];
                    }
                    else if (p.charAt(j-1)!='*'){
                        result[i][j]=result[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1);
                    }
                    else
                    {
//                        if (j==1) result[i][j]=true;
//                        else
//                        {
//                            for (int k=i;k>=0;k--)
//                            {
//                                if (result[k][j-1])
//                                {
//                                    result[i][j]=true;
//                                    break;
//                                }
//                            }
//                        }
                        result[i][j]=result[i][j-1]||result[i-1][j];
                    }

                }
            }
        for (int i=0;i<=length1;i++)
        {
            for (int j=0;j<=length2;j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        return result[length1][length2];
    }

    @Test
    public void test()
    {
        isMatch("adceb","*a*b");
    }
}
