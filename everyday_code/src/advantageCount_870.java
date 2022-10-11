import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class advantageCount_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        ArrayList<Pair<Integer,Integer>> list=new ArrayList<>();
        for (int i=0;i<length;i++)
        {
            list.add(new Pair(i,nums2[i]));
        }
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        Arrays.sort(nums2);
        for (int i=0;i<length/2;i++)
        {
            int temp=nums1[i];
            nums1[i]=nums1[length-i-1];
            nums1[length-i-1]=temp;
        }
        int[] result = new int[length];
        int index=0;
        int temp=0;
        for (int i=0;i<length;i++)
        {
            if (temp>=length)break;
            Pair<Integer, Integer> pair = list.get(temp);
            while (pair.getValue()>=nums1[i])
            {
                if (temp>=length)break;
                temp++;
                pair=list.get(temp);
            }
            temp++;
            index++;
            result[pair.getKey()]=nums1[i];
        }
        int i=0;
        while (index<length)
        {
            while (result[i]!=0)
            {
                i++;
            }
            result[i]=nums1[index];
            index++;
        }
        return result;
    }

    @Test
    public void test()
    {
        advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11});
    }
}
