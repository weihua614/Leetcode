package October_2022;

import org.junit.Test;

import java.util.Arrays;

public class maxChunksToSorted_769 {
    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        Integer[]index=new Integer[length];
        for (int i=0;i<length;i++)
        {
            index[i]=i;
        }
        Arrays.sort(index,(i,j)->(arr[i]-arr[j]));
        boolean flag=true;
        int result=0;
        int next=-1;
        for (int i=0;i<length;i++)
        {
            if (flag)
            {
                if (i==arr[i])
                {
                    result++;
                }
                else if (i<arr[i])
                {
                    flag=false;
                    next=arr[i];
                }
            }
            else
            {
                if (i>=arr[i]&&i==next)
                {
                    result++;
                    flag=true;
                }
                else
                {
                    next=Math.max(next,arr[i]);
                }
            }
        }
        if (next==0) result++;
        return result;
    }
    @Test
    public void test()
    {
        maxChunksToSorted(new int[]{4,3,2,1,0});
    }
}
