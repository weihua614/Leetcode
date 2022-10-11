import org.junit.Test;

public class minSwap_801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int result[][]=new int[nums1.length][2];
        int length = nums1.length;
        for (int i=1;i<length;i++)
        {
            result[i][0]=Integer.MAX_VALUE/2;
            result[i][1]=Integer.MAX_VALUE/2;
            swap(nums1,nums2,i-1);
            if (increaseNums(nums1,nums2,i))
            {
                if(i!=1)
                result[i][1]=Math.min(result[i][1],result[i-1][0]);
                else
                {
                    result[i][1]=1;
                }
            }
            swap(nums1,nums2,i-1);
            if (increaseNums(nums1,nums2,i))
            {
                result[i][1]=Math.min(result[i][1],result[i-1][1]);
            }
                swap(nums1,nums2,i);
                if (increaseNums(nums1,nums2,i))
                {
                    result[i][0]=Math.min(result[i-1][1]+1,result[i][0]);
                }
                swap(nums1,nums2,i-1);
                if (increaseNums(nums1,nums2,i))
                {
                    result[i][0]=Math.min(result[i-1][0]+1,result[i][0]);
                }
                swap(nums1,nums2,i);
                    if (increaseNums(nums1,nums2,i))
                    {
                        if (i==1)
                        {
                            result[i][1]=1;
                        }
                        else
                        {
                            result[i][1]=Math.min(result[i][1],result[i-1][0]+1);
                        }
                    }

                swap(nums1,nums2,i-1);
            }
        return  Math.min(result[length-1][0],result[length-1][1]);
    }
    public boolean increaseNums(int[] nums1, int[] nums2,int index)
    {
        if (index>=nums1.length) return false;
        if (nums1[index]>nums1[index-1]&&nums2[index]>nums2[index-1]) return true;
        else return false;
    }
    public void swap(int[] nums1, int[] nums2,int index)
    {
        int temp=nums1[index];
        nums1[index]=nums2[index];
        nums2[index]=temp;
    }
/*
[0,7,8,10,10,11,12,13,19,18]
[4,4,5,7,11,14,15,16,17,20]

[0,7  4 7
[4,4  0 7
      0 4
      4 7
[0,7,8
[4,4,5
 */
    @Test
    public void test()
    {
        minSwap(new int[]{1,3,5,4},new int[]{1,2,3,7});
    }

    public int minSwap1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }
}
