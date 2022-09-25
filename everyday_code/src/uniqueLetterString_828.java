import org.junit.Test;

import java.util.*;

public class uniqueLetterString_828 {
//    int sum=0;
//    public int uniqueLetterString(String s) {
//        recall(s,0);
//        return sum;
//    }
//    public void recall(String s,int index)
//    {
//        for(int i=index;i<s.length();i++)
//        {
//            recall1(s,i,new StringBuilder());
//        }
//    }
//    public void recall1(String s,int index,StringBuilder str)
//    {
//        for(int i=index;i<s.length();i++)
//        {
//            str.append(s.charAt(i));
//            String temp=str.toString();
//            sum=sum+getStrDiffNums(temp);
//        }
//    }
//    public int getStrDiffNums(String s)
//    {
//
//        HashMap<Character,Integer> map=new HashMap<>();
//        int num=0;
//        for(int i=0;i<s.length();i++)
//        {
//            Character cha=s.charAt(i);
//            map.put(cha,map.getOrDefault(cha,0)+1);
//            if(map.get(cha)==1)num++;
//            if(map.get(cha)==2)num--;
//        }
//
//        return num;
//    }
//@Test public void test(){
//    System.out.println(getStrDiffNums("EE"));
//}
    HashMap<Character, ArrayList<Integer>> map=new HashMap<>();
    public int uniqueLetterString(String s) {
        for(int i=0;i<s.length();i++)
        {
            char temp=s.charAt(i);
            if(!map.containsKey(temp))
            {
                map.put(temp,new ArrayList<>());
                map.get(temp).add(-1);
            }
            map.get(temp).add(i);
        }
        int sum=0;
        for(Map.Entry<Character, ArrayList<Integer>> entry:map.entrySet())
        {
            ArrayList<Integer> list = entry.getValue();
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                sum += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return sum;
    }



    @Test public void test(){
        uniqueLetterString("ABCBCABCDJC");
        System.out.println(map);
}
}
