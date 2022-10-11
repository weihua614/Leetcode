import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class scoreOfParentheses_856 {
    public int scoreOfParentheses1(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
           if (chars[i]=='('&&chars[i+1]==')')
           {
               list.add(1);
               i++;
           }
           else if (chars[i]=='(')
           {
               list.add(-1);
           }
           else
           {
               list.add(-2);
           }
        }
        while (list.size()>1)
        {
            for (int i=0;i<list.size();i++)
            {
                if (i+1>=list.size()) break;
                if (list.get(i)>0&&list.get(i+1)>0)
                {
                    list.set(i,list.get(i)+list.get(i+1));
                    list.remove(i+1);
                  //  break;
                }
            }
            for (int i=list.size()-1;i>=0;i--)
            {
                if (list.get(i)==-1)
                {
                    int sum=0;
                    int index=i+1;
                    while (index<list.size()&&list.get(index)!=-2)
                    {
                        if (list.get(index)>0)
                        {
                            sum+=list.get(index);
                            list.remove(index);
                        }
                    }
                    list.set(i,sum*2);
                    list.remove(index);
                }
            }
        }


        return list.get(0);

    }
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> list=new LinkedList<>();
        int index=0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        while (index<length)
        {
            if (chars[index]=='(')
            {
                list.add(-1);
            }
            else
            {
                if (chars[index]==')')
                {
                    if (list.getLast()==-1)
                    {
                        list.removeLast();
                        list.add(1);
                    }
                    else
                    {
                        int sum=0;
                        while (list.getLast()!=-1)
                        {
                            sum+=list.removeLast();
                        }
                        list.removeLast();
                        list.add(2*sum);
                    }
                }
            }
            index++;
        }
        int sum=0;
        while (list.size()>0)
            sum+=list.removeLast();
        return list.getFirst();
    }
    @Test
    public void test()
    {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
