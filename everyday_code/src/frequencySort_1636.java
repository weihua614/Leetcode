import java.util.*;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 */
public class frequencySort_1636 {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int result[]=new int[nums.length];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                Integer o1Value = o1.getValue();
                Integer o2Value = o2.getValue();
                if(o1Value==o2Value)
                {
                    return o2.getKey()-o1.getKey();
                }
                else return o1Value-o2Value;
            }
        });
        int index=0;
        for(int i=0;i<list.size();i++)
        {
            Integer key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            for(int j=0;j<value;j++)
            {
                result[index]=key;
                index++;
            }
        }
        return result;
    }
}
