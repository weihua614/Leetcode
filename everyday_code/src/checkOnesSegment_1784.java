public class checkOnesSegment_1784 {
    public boolean checkOnesSegment(String s) {
        if(s.length()<=2) return true;
        char[] chars = s.toCharArray();
        boolean flag1=false;
        for (int i=1;i<chars.length;i++)
        {
            if (!flag1&&chars[i]=='1')
            {
                continue;
            }
            if (!flag1&&chars[i]=='0')
            {
                flag1=true;
                continue;
            }
            if (chars[i]=='1')
                return false;
        }
        return true;
    }
}
