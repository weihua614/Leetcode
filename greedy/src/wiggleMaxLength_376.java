public class wiggleMaxLength_376 {
    public int wiggleMaxLength(int[] nums) {
        int sum=0;
        boolean flag=false;
        if(nums.length==1)  return 1;
        if(nums.length==2)
        {
            if (nums[0]==nums[1]) {
                return 1;
            }
            else return 2;
        }
        for(int i=1;i<nums.length;i++)
        {
            if(i==1)
            {
                while(i<nums.length&&nums[i]-nums[i-1]!=0)
                {
                    i++;
                }
                if(i==nums.length) return 1;
                flag=nums[i]-nums[i-1]>0?true:false;
                sum+=2;
            }
            else if(nums[i]-nums[i-1]>0&&!flag)
            {
                flag=!flag;
                sum++;
            }
            else if(nums[i]-nums[i-1]<0&&flag)
            {
                flag=!flag;
                sum++;
            }
            System.out.print(flag);
            System.out.println(sum);
        }
        return sum;
    }
}
