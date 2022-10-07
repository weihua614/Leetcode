public class isSubsequence_392 {//392
    public boolean isSubsequence1(String s, String t) {
        int length1=s.length();
        int length2=t.length();
        boolean result[][]=new boolean[length1+1][length2+1];
        if (length1==0) return false;
        for (int i=0;i<=length2;i++)
        {
            result[0][i]=true;
        }
        for (int i=1;i<=length1;i++)
        {
            for (int j=1;j<length2;j++)
            {
                if (s.charAt(i-1)==t.charAt(j-1))
                {
                    result[i][j]=result[i-1][j-1]||result[i][j-1];
                }
                else
                {
                    result[i][j]=result[i][j-1];
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        return result[length1][length2];
    }
    public boolean isSubsequence(String s, String t) {
        if (t.length()<s.length()) return false;
        char[]schar=s.toCharArray();
        char[]tchar=t.toCharArray();
        int i=0;
        int j=0;
        while (j<t.length()&&i<s.length())
        {
            if (schar[i]==tchar[j])
            {
                i++;
            }
            j++;
        }
        if (i==s.length())return true;
        else  return false;
    }
}
