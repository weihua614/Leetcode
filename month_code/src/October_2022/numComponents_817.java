package October_2022;

import java.util.HashSet;

public class numComponents_817 {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int count=0;
        int result=0;
        while (head!=null)
        {
            if (set.contains(head.val))
            {
                count++;
            }
            else
            {
                if (count>0)
                {
                    result++;
                }
                count=0;
            }
            head=head.next;
        }
        if (count>0)
        {
            result++;
        }
        return result;
    }
}
