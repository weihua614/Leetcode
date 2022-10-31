package October_2022;

import java.util.HashMap;
import java.util.List;

public class countMatches_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("type",0);
        map.put("color",1);
        map.put("name",2);
        int index=map.get(ruleKey);
        int result=0;
        for (int i=0;i<items.size();i++)
        {
            List<String> li = items.get(i);
            if (li.get(index).equals(ruleValue))
                result++;
        }
        return result;
    }
}
