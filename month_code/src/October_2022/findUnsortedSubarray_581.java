package October_2022;

import org.junit.Test;
import sun.security.util.Length;

import java.util.Arrays;

public class findUnsortedSubarray_581 {
    public int findUnsortedSubarray1(int[] nums) {
        int length = nums.length;
        Integer[] index=new Integer[length];
        for (int i=0;i<length;i++)
        {
            index[i]=i;
        }
        Arrays.sort(index,(i,j)->(nums[i]-nums[j]));
        int left=0;
        int right=length-1;
        while (left<length)
        {
            if (left==index[left])
            {
                left++;
            }
            else
            {
                break;
            }
        }
        while (right>=0)
        {
            if (right==index[right])
            {
                right--;
            }
            else
            {
                break;
            }
        }
        if (right<left)return 0;
        else  return right-left+1;
    }
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int coNums[]=new int[length];
        for (int i=0;i<length;i++)
        {
            coNums[i]=nums[i];
        }
        buildMax(coNums);
        int right=length-1;
        while (right>=0)
        {
            if (nums[right]==coNums[0])
            {
                swap(coNums,0,right);
                right--;
                buildA(coNums,right+1,0);
            }
            else
            {
                break;
            }
        }
        if (right==-1) return 0;
        buildMin(coNums);
        int left=0;
        while (left<=right)
        {
            if (nums[left]==coNums[0])
            {
                swap(coNums,0,length-1-left);
                left++;
                buildI(coNums,length-left,0);
            }
            else break;
        }
        if (left>=right) return 0;
        else return  right-left+1;
    }
    public void buildMax(int[] nums)
    {
        int length=nums.length;
        for (int i=nums.length/2;i>=0;i--)
        {
            buildA(nums,length,i);
        }
    }
    public void buildA(int[] nums,int size,int index)
    {

        int left=index*2+1;
        int right=index*2+2;
        int larg=index;
        if (left<size&&nums[left]>nums[larg])
        {
            larg=left;
        }
        if (right<size&&nums[right]>nums[larg])
        {
            larg=right;
        }
        if (larg!=index)
        {
            swap(nums,larg,index);
            buildA(nums,size,larg);
        }

    }
    public void buildMin(int[] nums)
    {
        int length=nums.length;
        for (int i=nums.length/2;i>=0;i--)
        {
            buildI(nums,length,i);
        }
    }
    public void buildI(int[] nums,int size,int index)
    {
        int left=index*2+1;
        int right=index*2+2;
        int larg=index;
        if (left<size&&nums[left]<nums[larg])
        {
            larg=left;
        }
        if (right<size&&nums[right]<nums[larg])
        {
            larg=right;
        }
        if (larg!=index)
        {
            swap(nums,larg,index);
            buildI(nums,size,larg);
        }
    }
    public void swap(int[] nums,int index1,int index2)
    {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    public int findUnsortedSubarray3(int[] nums) {
        int length=nums.length;
        if (length<2) return length;
        int left=1;
        int right=length-1;
        while (left<length)
        {
            if (nums[left]>=nums[left-1])
            {
                left++;
            }
            else
            {
                int index=left;
                left--;
                while (left>=0&&nums[index]<nums[left])
                {
                    left--;
                }
                break;
            }
        }
        if (left==length) return 0;
        while (right-1>=0)
        {
            if (nums[right]>=nums[right-1])
            {
                right--;
            }
            else
            {
                right--;
                int index=right;
                right++;
                while (right<length&&nums[index]>nums[right])
                {
                    right++;
                }
                break;
            }
        }
        return right-left-1;
    }

    @Test
    public void test()
    {
        System.out.println(findUnsortedSubarray3(new int[]{2,6,4,8,10,9,15}));
    }
}
