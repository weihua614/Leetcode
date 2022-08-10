package code;

import java.util.LinkedList;

public class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue=new LinkedList<Integer>();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            if(i==0)
            {
                queue.add(nums[i]);
            }
            else
            {
                while(!queue.isEmpty()&&nums[i]>queue.getLast())
                {
                    queue.removeLast();
                }
                queue.add(nums[i]);
            }
        }
        for(int i=k;i<nums.length;i++)
        {
            if(nums[i-k]==queue.getFirst())
            {
                result[i-k]=queue.removeFirst();
            }
            else result[i-k]=queue.getFirst();
                while(!queue.isEmpty()&&nums[i]>queue.getLast())
                {
                    queue.removeLast();
                }
                queue.add(nums[i]);

        }
        result[nums.length-k]=queue.getFirst();
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow_239 maxSlidingWindow_239 = new MaxSlidingWindow_239();
        int[] ints = maxSlidingWindow_239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for(int i:ints)
            System.out.println(i);
    }
}
