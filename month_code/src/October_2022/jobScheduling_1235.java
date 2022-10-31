package October_2022;

import org.junit.Test;

import java.util.*;

public class jobScheduling_1235 {
    int result[];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Integer[]index=new Integer[endTime.length];

        for (int i=0;i<index.length;i++)
        {
            index[i]=i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return endTime[o1]-endTime[o2];
                    }
                }
        );
        result=new int[endTime[index[endTime.length-1]]+1];
        result[endTime[index[0]]]=profit[index[0]];
        int max=0;
        for (int i=endTime[index[0]]+1;i<=result.length;i++)
        {
            Integer index1 = index[i];
            int canWorkTime = getCanWorkTime(index, i, startTime, endTime);
            result[endTime[index1]]=Math.max(profit[index1]+canWorkTime,result[endTime[index1]]);
            max=Math.max(max,result[endTime[index1]]);
        }
        return max;
    }
    public int getCanWorkTime(Integer[]index,int temIndex,int[] startTime, int[] endTime)
    {
        int sIndex=index[temIndex];
        int temStart=startTime[sIndex];
        int max=0;
        for (int i=0;i<temIndex;i++)
        {
            if (temStart>=endTime[index[i]])
            {
                max=Math.max(result[endTime[index[i]]],max);
            }
        }
        return max;
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int max=0;
        int secMac=0;
        int maxIndex=0;
        for (int i=0;i<endTime.length;i++)
        {
            if (!map.containsKey(endTime[i]))
            {
                map.put(endTime[i],new ArrayList<>());
            }
            map.get(endTime[i]).add(new int[]{startTime[i],profit[i]});
            if (endTime[i]>max)
            {
                secMac=max;
                maxIndex=i;
                max=endTime[i];

            }
            else
            {
                secMac=Math.max(secMac,endTime[i]);
            }
        }
        int result[]=new int[secMac+2];
        for (int i=1;i<result.length;i++)
        {
            if (!map.containsKey(i))
            {
                if (i==result.length-1)
                {
                    result[i]=result[i-1];
                    ArrayList<int[]> ints = map.get(endTime[maxIndex]);
                    for (int j=0;j<ints.size();j++)
                    {
                        int[] ints1 = ints.get(j);
                        result[i]=Math.max(result[i],result[ints1[0]]+ints1[1]);
                    }
                    break;
                }
                result[i]=result[i-1];
            }
            else
            {
                result[i]=result[i-1];
                ArrayList<int[]> ints = map.get(i);
                for (int j=0;j<ints.size();j++)
                {
                    int[] ints1 = ints.get(j);
                    result[i]=Math.max(result[i],result[ints1[0]]+ints1[1]);
                }
            }
        }
        return result[result.length-1];

    }

    @Test
    public void test()
    {
        /**
         * [6,24 ,45,27,13,43,47,36,14 ,11,11 ,12]
         * [31,27 ,48,46,44,46,50,49,24 ,42,13 ,27]
         * [14,4 ,16,12,20,3,18,6,9 ,1,2 ,8]
         * 输出：
         *
         * [1,2,3,3]
         * [3,4,5,1000000000]
         * [50,10,40,70]
         */
        jobScheduling1(new int[]{1,2,3,3},new int[]{3,4,5,1000000000},new int[]{50,10,40,70});
    }
}
