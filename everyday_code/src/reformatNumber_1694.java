import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class reformatNumber_1694 {
    public String reformatNumber1(String number) {
        char[] chars = number.toCharArray();
        int nums=0;
        int left=0;
        for (int i=0;i<chars.length;i++)
        {
            if (chars[i]!=' '&&chars[i]!='-')
            {
                chars[left]=chars[i];
                left++;
                nums++;
            }
        }
        if (nums<=3) return new String(chars,0,nums);
        if (nums==4) return new String(new char[]{chars[0],chars[1],'-',chars[2],chars[3]});
        int threeNums=nums%3;
        int lastNums=0;
        if (threeNums==1)
        {
            threeNums=nums/3-1;
            lastNums=nums-threeNums*3;
        }
        else
        {
            threeNums=nums/3;
            lastNums=nums%3;
        }
        left=0;
        char []result;
        if (lastNums!=4)result=new char[nums+threeNums-(lastNums==0?1:0)];
        else result=new char[nums+threeNums+1];
        for (int i=0;i<threeNums;i++)
        {
            if (i!=0)
            {
                result[left]='-';
                left++;
            }
            result[left]=chars[i*3];
            left++;
            result[left]=chars[i*3+1];
            left++;
            result[left]=chars[i*3+2];
            left++;
        }
        if (lastNums!=4)
        {
            for (int i=nums-lastNums;i<nums;i++)
            {
                if (i==nums-lastNums&&threeNums!=0)
                {
                    result[left]='-';
                    left++;
                }
                result[left]=chars[i];
                left++;
            }
        }
        else
        {
            int length = result.length;
            result[length-6]='-';
            result[length-5]=chars[nums-4];
            result[length-4]=chars[nums-3];
            result[length-3]='-';
            result[length-2]=chars[nums-2];
            result[length-1]=chars[nums-1];
        }
        return new String(result);
    }

    public String reformatNumber(String number)
    {
        char[] chars = number.toCharArray();
        LinkedList<Character> characters = new LinkedList<>();
        for (int i=0;i<chars.length;i++)
        {
            if (chars[i]!='-'&&chars[i]!=' ')
                characters.add(chars[i]);
        }
        StringBuffer result=new StringBuffer();
        while (characters.size()>4)
        {
            if (result.length()!=0)
            {
                result.append('-');
            }
            for (int i=0;i<3;i++)
            result.append(characters.removeFirst());
        }
        if (characters.size()==4)
        {
            if (result.length()!=0)
            {
                result.append('-');
                result.append(characters.removeFirst());
                result.append(characters.removeFirst());
                result.append('-');
                result.append(characters.removeFirst());
                result.append(characters.removeFirst());
            }
            else
            {
                result.append(characters.removeFirst());
                result.append(characters.removeFirst());
                result.append('-');
                result.append(characters.removeFirst());
                result.append(characters.removeFirst());
            }
        }
        else
        {
            if (result.length()!=0)
            {
                result.append('-');
                while (characters.size()!=0)
                result.append(characters.removeFirst());
            }
            else
            {
                while (characters.size()!=0)
                    result.append(characters.removeFirst());
            }
        }
        return new String(result);
    }
    @Test
    public void test()
    {
        System.out.println(reformatNumber("915-03"));
    }
}
