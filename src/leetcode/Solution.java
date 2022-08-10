package leetcode;
import java.util.*;
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int num=0;
        boolean flag = false;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0) num++;
            else
            if(i==1)
            {
                if(nums[i]-nums[i-1]>0)
                    flag=true;
                num++;
            }
            else
            {
                if((nums[i]-nums[i-1]>0)==flag)
                {
                    continue;
                }
                else
                {
                    if(flag) flag=false;
                    else flag=true;
                    num++;
                }
            }
        }
        return num;
    }
}