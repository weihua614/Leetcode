import org.junit.Test;

import java.util.LinkedList;

public class decodeString_374 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> list=new LinkedList<>();
        LinkedList<Integer> list1=new LinkedList<>();
        StringBuffer result=new StringBuffer();
        for (int i=0;i<chars.length;i++)
        {
            if (chars[i]=='[')
            {
                list.add('[');
            }
            else if (chars[i]<='9'&&chars[i]>='0')
            {
                StringBuffer temp=new StringBuffer();
                temp.append(chars[i]);
                while (chars[i+1]<='9'&&chars[i+1]>='0')
                {
                    i++;
                    temp.append(chars[i]);
                }
                list1.add(Integer.valueOf(temp.toString()));
            }
            else if (chars[i]<='z'&&chars[i]>='a')
            {
                if (list.size()==0)
                {
                    result.append(chars[i]);
                }
                else
                {
                    list.add(chars[i]);
                }
            }
            else
            {
                char temp=list.removeLast();
                LinkedList<Character> cha=new LinkedList<>();
                while (temp<='z'&&temp>='a')
                {
                    cha.addFirst(temp);
                    temp=list.removeLast();
                }
                StringBuffer buffer=new StringBuffer();
                while (cha.size()>0)
                {
                    buffer.append(cha.removeFirst());
                }
                String s1 = buffer.toString();
                char[] chars1 = s1.toCharArray();
                int index=list1.removeLast();
                if (list.size()==0)
                {
                    for (int j=0;j<index;j++)
                    {
                        result.append(s1);
                    }
                }
                else
                {
                    for (int j=0;j<index;j++)
                    {
                        for (int k=0;k<chars1.length;k++)
                        {
                            list.add(chars1[k]);
                        }
                    }
                }
            }
        }
        return result.toString();
    }
    @Test
    public void test
            (){
        System.out.println(decodeString("100[a]"));
    }
}
