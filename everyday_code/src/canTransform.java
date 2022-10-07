
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class canTransform {
    public boolean canTransform(String start, String end) {
        if (start.length()!=end.length()) return false;
        char[] chars1 = start.toCharArray();
        char[] chars2 = end.toCharArray();
        LinkedList<Integer> startL = new LinkedList<>();
        LinkedList<Integer> startR = new LinkedList<>();
        LinkedList<Integer> endL = new LinkedList<>();
        LinkedList<Integer> endR = new LinkedList<>();
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int num1=0;
        int num2=0;
        for (int i=0;i<chars1.length;i++)
        {
            if (chars1[i]=='X')
            {
                num1++;
            }
            if (chars2[i]=='X')
            {
                num2++;
            }
            if (chars1[i]!='X')
            {
                stringBuffer1.append(chars1[i]);
                if (chars1[i]=='R')
                {
                    startR.add(num1);
                }
                if (chars1[i]=='L')
                {
                    startL.add(num1);
                }
            }
            if (chars2[i]!='X')
            {
                stringBuffer2.append(chars2[i]);
                if (chars2[i]=='R')
                {
                    endR.add(num2);
                }
                if (chars2[i]=='L')
                {
                    endL.add(num2);
                }
            }
        }
        if (!stringBuffer1.toString().equals(stringBuffer2.toString())) return false;
        while (startL.size()!=0)
        {
            if (startL.removeFirst()<endL.removeFirst())
                return false;
        }
        while (startR.size()!=0)
        {
            if (startR.removeFirst()>endR.removeFirst())
                return false;
        }
        return true;
    }


    @Test
    //"XXXXXXXRXXXXXXXLXXXXXXXRXXXXXX"
    //"XXXXXXRXXXXXXLXXXXXXXXXRXXXXXX"
    //"XXXXXXXRXXXXXXXLXXXXXXXRXXXXXX"
    //"XXXXXXRXXXXXXLXXXXXXXXXRXXXXXX"
    public void test()
    {
        System.out.println(canTransform("XXXXXXXRXXXXXXLXXXXXXXXRXXXXXX", "XXXXXXRXXXXXXLXXXXXXXXXRXXXXXX"));
    }
}
