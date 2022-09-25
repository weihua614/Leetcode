import org.junit.Test;

import java.util.ArrayList;

public class reorderSpaces_1592 {
    public String reorderSpaces(String text) {
        ArrayList<String> list=new ArrayList<>();
        int SpaceNums=0;
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)==' ')
            {
                SpaceNums++;
            }
            else
            {
                int start=i;
                while(i+1<text.length()&&text.charAt(i+1)!=' ')
                {
                    i++;
                }
                list.add(text.substring(start,i+1));
            }
        }
        StringBuilder str=new StringBuilder(text.length());
        if(list.size()==1)
        {
            str.append(list.get(0));
            for(int j=0;j<SpaceNums;j++)
            {
                str.append(' ');
            }
            return str.toString();
        }
        int mid=SpaceNums/(list.size()-1);
        int last=SpaceNums%(list.size()-1);
        for(int i=0;i<list.size();i++)
        {
            if(i!=list.size()-1)
            {
                str.append(list.get(i));
                for(int j=0;j<mid;j++)
                {
                    str.append(' ');
                }
            }
            else
            {
                str.append(list.get(i));
                for(int j=0;j<last;j++)
                {
                    str.append(' ');
                }
            }
        }
        return str.toString();
    }






    @Test
    public void test()
    {
        reorderSpaces("  this   is  a sentence ");
    }
}
