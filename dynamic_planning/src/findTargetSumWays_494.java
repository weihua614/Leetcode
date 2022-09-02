import java.util.LinkedList;

public class findTargetSumWays_494 {
    int result=0;
    //LinkedList<Integer> list=new LinkedList<>();
    public int findTargetSumWays1(int[] nums, int target) {
        recall(nums,target,0);
        return result;
    }
    public void recall(int []nums,int target,int index)
    {
        if(nums.length==index)
        {
            if(target==0) result++;
            return;
        }
        int add=target-nums[index];
        recall(nums,add,index+1);
        add=target+nums[index];
        recall(nums,add,index+1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int temp=(sum-target);
        if(temp<0||temp%2!=0) return 0;
        temp=temp/2;
        // System.out.println(temp);
        int result[]=new int[temp+1];
        result[0]=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=temp;j>=nums[i];j--)
            {
                result[j]=result[j]+result[j-nums[i]];
                //  System.out.print(result[j]);
            }
            // System.out.println();
        }
        return result[temp];
    }
}
