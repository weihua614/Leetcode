import org.junit.Test;

public class lastStoneWeightII_1049 {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length==1) return stones[0];
        int sum=0;
        for(int i=0;i<stones.length;i++)
        {
            sum+=stones[i];
        }
        int result[]=new int[sum/2+1];
        result[0]=0;
        for(int i=0;i<stones.length;i++)
        {
            for(int j=result.length-1;j>=stones[i];j--)
            {
                result[j]=Math.max(result[j],result[j-stones[i]]+stones[i]);
            }
        }
        return (sum-2*result[result.length-1]);
    }
    @Test
    public void test(){
        System.out.println(lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
}
