import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class findMedianSortedArrays_4 {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(nums1.length, nums2.length);
        int length1 = nums1.length;
        int length2 = nums2.length;

        for (int i = 0; i < max; i++) {
            if (i < length1) {
                list.add(nums1[i]);
            }
            if (i < length2) {
                list.add(nums2[i]);
            }
        }
        Collections.sort(list);
        double result=0;
        if (list.size()%2==0)
        {
            int tem1=list.get(list.size()/2-1);
            System.out.println(tem1);
            int tem2=list.get(list.size()/2);
            System.out.println(tem2);
            result=(tem1+tem2)/(double)2;
        }
        else
        {
            result=list.get(list.size()/2);
        }
        return result;

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int result[]=new int[nums1.length+nums2.length];
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum=length1+length2;
        int left=0;
        int right=0;
        for (int i=0;i<sum;i++)
        {
            if (left>=length1)
            {
                result[i]=nums2[right];
                right++;
                continue;
            }
            if (right>=length2)
            {
                result[i]=nums1[left];
                left++;
                continue;
            }
            if (nums1[left]>nums2[right])
            {
                result[i]=nums2[right];
                right++;
            }
            else {
                result[i]=nums1[left];
                left++;
            }
        }
        if (sum%2==1)
        {
            return result[sum/2];
        }
        else
        {
            return  (result[sum/2]+result[sum/2-1])/(double)2;
        }
    }
    @Test
    public void test()
    {
        System.out.println(findMedianSortedArrays(new int[]{1,1}, new int[]{1,2}));
    }
}
