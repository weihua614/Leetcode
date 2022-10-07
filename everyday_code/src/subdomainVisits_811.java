
import org.junit.Test;

import java.util.*;

public class subdomainVisits_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++)
        {
            String[] s = cpdomains[i].split(" ");
            Integer integer = Integer.valueOf(s[0]);
            map.put(s[1],map.getOrDefault(s[1],0)+Integer.valueOf(s[0]));
            char[] chars = s[1].toCharArray();
            int length = chars.length;
            int index=0;
            while (index<chars.length)
            {
                if (chars[index]=='.')
                {
                    String temp=new String(chars,index+1,length-index-1);
                    map.put(temp,map.getOrDefault(temp,0)+integer);
                }
                index++;
            }
        }
        ArrayList<String> result = new ArrayList<>(map.size());
        for (Map.Entry<String,Integer> i:map.entrySet())
        {
            result.add(i.getValue()+" "+i.getKey());
        }
        System.out.println(result);
        return result;
    }

    @Test
    public void test()
    {
        subdomainVisits(new String[]{"900 google.mail.com","50 yahoo.com","1 intel.mail.com","5 wiki.org"});
    }
}
