import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class canBeEqual_1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length!=arr.length) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<target.length;i++)
        {
            map.put(target[i],map.getOrDefault(target[i],0)+1);
            map.put(arr[i],map.getOrDefault(arr[i],0)-1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer>i:entries)
        {

            if(i.getValue()!=0) return false;
        }
        return true;
    }
    
}
