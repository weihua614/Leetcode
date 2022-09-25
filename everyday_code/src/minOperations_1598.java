import java.util.HashMap;

public class minOperations_1598 {
    public int minOperations(String[] logs) {
        int result=0;
       // HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("../"))
            {
                result=result==0?0:result-1;
            }
            else if(logs[i].equals("./")) continue;
            else
            {
                result++;

            }
        }
        return result;
    }
}
