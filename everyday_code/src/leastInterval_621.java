import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class leastInterval_621 {
    HashMap<Character, ArrayList<Integer>> sumTask=new HashMap<>();
    public int leastInterval(char[] tasks, int n) {
        for(char temp:tasks)
        {
            if(!sumTask.containsKey(temp))
            {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(1);
                sumTask.put(temp,list);
            }
            else
            {
                ArrayList<Integer> list = sumTask.get(temp);
                list.set(1,list.get(1)+1);
            }
        }
        System.out.println(sumTask);
        System.out.println();
        int result=0;
        while(true)
        {
            char task = getTask();
            if(task=='0') break;
            result++;
            for(HashMap.Entry<Character,ArrayList<Integer>> taskmap:sumTask.entrySet())
            {
                Character key = taskmap.getKey();
                ArrayList<Integer> value = taskmap.getValue();
                if(key!=task)
                {
                    if(value.get(0)>1) value.set(0,value.get(0)-1);
                }
                else
                {
                    value.set(0,n+1);
                    value.set(1,value.get(1)-1);
                }
            }
        }
        return result;
    }
    public char getTask()
    {
        System.out.println(sumTask);
        char taskMax='0';
        int numMax=0;
        for(HashMap.Entry<Character,ArrayList<Integer>> task:sumTask.entrySet())
        {
            ArrayList<Integer> value = task.getValue();
            if(value.get(0)==1&&value.get(1)>numMax)
            {
                numMax=value.get(1);
                taskMax=task.getKey();
            }
            else if(taskMax=='0'&&value.get(0)>1&&value.get(1)>=1)
            {
                taskMax='1';
            }
            System.out.print(taskMax);
        }
        System.out.println();
        return taskMax;
    }


    @Test
    public void test(){
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}

