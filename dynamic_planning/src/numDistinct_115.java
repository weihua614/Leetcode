import java.util.Arrays;

public class numDistinct_115 {
    public int numDistinct(String s, String t) {
        /*  //bag babgbag           rabbit      rabbbit
             //b   1122333          r           1111111
        //ba  0111144               ra          0111111
        //bag 0001115               rab         0012333
                                    rabb        0001333
                                    rabbi       000003
 */
        char schar[]=t.toCharArray();
        char tchar[]=s.toCharArray();
        int result[][]=new int[schar.length+1][tchar.length+1];
        Arrays.fill(result[0],1);
        for (int i=1;i<=schar.length;i++)
        {
            for (int j=i;j<=tchar.length;j++)
            {
                if (schar[i-1]!=tchar[j-1])
                {
                    result[i][j]=result[i][j-1];
                }
                else
                {
                    result[i][j]=result[i-1][j-1]+result[i][j-1];
                }
                //   System.out.print(result[i][j]);
            }
            //   System.out.println();
        }
        return result[schar.length][tchar.length];
    }
}
