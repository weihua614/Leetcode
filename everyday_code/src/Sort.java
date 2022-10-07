import org.junit.Test;

import java.util.Random;

public class Sort {
    public void heapSort(int[]nums)
    {
        int length=nums.length;
        for (int i=length/2;i>=0;i--) buildHeap(nums,i,length);
        while (length>0)
        {
            swap(nums,0,length-1);
            length--;
            buildHeap(nums,0,length);
        }
        System.out.println();
        for (int i:nums)
        {
            System.out.print(i+",");
        }
    }
    public void buildHeap(int[]nums,int index,int size)
    {
            int left=index*2+1;
            int right=index*2+2;
            int max=index;
            if (left<size&&nums[left]>nums[max])
            {
                max=left;
            }
            if (right<size&&nums[right]>nums[max])
            {
                max=right;
            }
            if (max!=index)
            {
                swap(nums,max,index);
                buildHeap(nums,max,size);
            }
    }
    public void swap(int[]nums,int index1,int index2)
    {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
    @Test
    public void test()
    {
//        int[] ints = new int[5];
//        for (int i=0;i<5;i++)
//        {
//            Random random = new Random();
//            ints[i]=random.nextInt(1000);
//        }
//        for (int i:ints)
//        {
//            System.out.print(i+",");
//        }
        heapSort(new int[]{339,446,97,738,248});
    }



    public int[] sortArray(int[] nums) {
        heapSort1(nums);
        return nums;
    }

    public void heapSort1(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

}
