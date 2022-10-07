
import org.junit.Test;

import java.util.ArrayList;

public class countSubstrings_647 {
    //https://leetcode.cn/problems/palindromic-substrings/
    //回溯
    ArrayList<String> result=new ArrayList<>();
    public int countSubstrings1(String s) {
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++)
        {
            recall(chars,i);
        }
        return result.size();
    }
    public void recall(char[]s,int index)
    {
        if (index>=s.length) return;
        for (int i=index;i<s.length;i++)
        {
            if (huiIsTrue(s,index,i))
            {
                result.add(new String(s,index,i-index+1));
            }
        }
    }
    public boolean huiIsTrue(char[]s,int left,int right)
    {
        while (left<right)
        {
            if (s[left]!=s[right]) return false;
            left++;
            right--;
        }
        return true;
    }


    public int countSubstrings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        boolean result[][]=new boolean[length][length];
        int num=0;
        for (int i=0;i<length;i++)
        {
            result[i][i]=true;
            num++;
            for (int j=0;j<i;j++)
            {
                if (chars[i]==chars[j]&&(i-1==j||result[i-1][j+1]))
                {
                    num++;
                    result[i][j]=true;
                }
            }
        }
        for (boolean[]a:result)
        {
            for (boolean b:a)
                System.out.print(b+",");
            System.out.println();
        }
        return num;
    }

    @Test
    public void test()
    {
        char[]a=new char[]{'a','b','a'};
        System.out.println(countSubstrings("aaaaa"));
    }
}
