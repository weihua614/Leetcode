package code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案
 */
public class TopKFrequent_237 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet()); //将map的entryset放入list集合
        //对list进行排序，并通过Comparator传入自定义的排序规则
        Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return -(o1.getValue()-o2.getValue());
            }
        });
        int[] result = new int[k];
        for(int i=0;i<k;i++)
        {
            result[i]=list.get(i).getKey();
        }
        return result;
    }

}
