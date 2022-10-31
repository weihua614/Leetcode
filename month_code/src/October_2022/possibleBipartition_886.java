package October_2022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class possibleBipartition_886 {
    HashMap <Integer, ArrayList<Integer>> map=new HashMap<>();
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int color[]=new int[n+1];
        ArrayList<Integer> list[]=new ArrayList[n+1];
        for (int i=0;i<=n;i++)
        {
            list[i]=new ArrayList<>();
        }
        for (int i=0;i<dislikes.length;i++)
        {
            list[dislikes[i][0]].add(dislikes[i][1]);
            list[dislikes[i][1]].add(dislikes[i][0]);
        }
        for (int i=1;i<=n;i++)
        {
            if (color[i]==0)
            {
                color[i]=1;
                if (!recall(list,color,i)) return false;
            }
        }
        return true;
    }
    public boolean recall1(ArrayList<Integer> list[],int color[],int index)
    {
        ArrayList<Integer> list1 = list[index];
        for (int i:list1)
        {
            if (color[i]==0)
            {
                if (color[index]==1)
                {
                    color[i]=2;
                }
                else
                {
                    color[i]=1;
                }
                if (!recall(list,color,i)) return false;
            }
            else
            {
                if (color[i]==color[index])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean recall(ArrayList<Integer> list[],int color[],int index)
    {
        LinkedList<Integer> stack=new LinkedList<>();
        stack.add(index);
        while (stack.size()>0)
        {
            ArrayList<Integer>temp1=list[stack.removeFirst()];
            for (int temp:temp1)
            {
                if (color[temp]==0)
                {
                    if (color[index]==1)
                    {
                        color[temp]=2;
                    }
                    else
                    {
                        color[temp]=1;
                    }
                    stack.add(temp);
                }
                else
                {
                    if (color[temp]==color[index])
                        return false;
                }
            }

        }
        return true;
    }

    @Test
    public void test()
    {
        possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}});
    }
}
