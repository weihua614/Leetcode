package October_2022;

public class areAlmostEqual_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int index1=-1;
        int index2=-1;
        int num=0;
        int length = chars1.length;
        for (int i=0;i<length;i++)
        {
            if (chars1[i]!=chars2[i])
            {
                num++;
                if (num>2) return false;
                if (num==1)  index1=i;
                if (num==2)  index2=i;
            }
        }
        if (index1==index2) return true;
        if (num==1) return false;
        if (chars1[index1]==chars2[index2]&&chars1[index2]==chars2[index1]) return true;
        else return false;
    }
}
