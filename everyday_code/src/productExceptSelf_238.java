import java.util.Arrays;

public class productExceptSelf_238 {
    public int[] productExceptSelf1(int[] nums) {
        int sum=1;
        boolean flag=false;
        int numZero=0;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==0)
            {
                numZero++;
                flag=true;
                if (numZero>=2) break;
            }
            else
                {
                    sum=sum*nums[i];
                }
        }
        int []result=new int[nums.length];
        if (!flag)
        {
            for (int i=0;i<nums.length;i++)
            {
                result[i]=sum/nums[i];
            }
        }
        else
        {
            if (numZero>=2)
            {
                Arrays.fill(result,0);
            }
            else
            {
                for (int i=0;i<nums.length;i++)
                {
                    if (nums[i]!=0)
                    {
                        result[i]=0;
                    }
                    else
                    {
                        result[i]=sum;
                    }
                }
            }
        }
        return result;
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int leftIndex[]=new int[length];
        int rightIndex[]=new int[length];
        int result[]=new int[length];
        leftIndex[0]=nums[0];
        rightIndex[length-1]=nums[length-1];
        for (int i=1;i<length;i++)
        {
            leftIndex[i]=leftIndex[i-1]*nums[i];
            rightIndex[length-i-1]=rightIndex[length-i]*nums[length-i-1];
        }
        result[0]=rightIndex[1];
        result[length-1]=leftIndex[length-2];
        for (int i=1;i<length-1;i++)
        {
            result[i]=leftIndex[i-1]*rightIndex[i+1];
        }
        return result;
    }
}
