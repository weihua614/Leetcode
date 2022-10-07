public class minAddToMakeValid_921 {
    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int left=0;
        int right=0;
        for (int i=0;i<chars.length;i++)
        {
            if (chars[i]=='(')
            {
                left++;
            }
            else
            {
                if (left>0)
                {
                    left--;
                }
                else right++;

            }
        }
        return left+right;
    }
}
