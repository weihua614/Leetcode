import org.junit.Test;

import java.util.HashMap;

public class canFormArray_1604 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //boolean[]flag=new boolean[pieces.length];
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<pieces.length;i++)
        {
            map.put(pieces[i][0],pieces[i]);
        }

        int index=0;
        while (index<arr.length)
        {
            if(!map.containsKey(arr[index])) return false;
            int nextIndex = getNextIndex(arr, map.get(arr[index]), index);
            if(nextIndex==-1) return false;
            index=nextIndex;
        }
        return true;
    }
    public int getNextIndex(int []arr,int []piece,int index)
    {
        if(index>=arr.length) return -1;
        if(arr[index]!=piece[0]) return -1;
        int nextIndex=1;
        for(;nextIndex<piece.length;nextIndex++)
        {
            if(arr[index+nextIndex]!=piece[nextIndex]) return -1;
        }
        return index+nextIndex;
    }
    @Test
    public void test()
    {
        System.out.println(canFormArray(new int[]{15, 88}, new int[][]{{15}, {88}}));
    }
}
