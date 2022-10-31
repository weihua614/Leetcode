package October_2022;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class sumSubarrayMins_907 {
    public int sumSubarrayMins(int[] arr) {
        final int value=1000000007;
        //LinkedList<Integer> stack=new LinkedList<>();
        int length=arr.length;
        int result=0;
        int min=Integer.MAX_VALUE;
        int MinNums[]=new int[length];
        MinNums[length-1]=arr[length-1];
        for (int i=length-2;i>=0;i--)
        {
            MinNums[i]=Math.min(MinNums[i+1],arr[i]);
        }
        for (int i=0;i<length;i++)
        {
            for (int j=i;j<length;j++)
            {
                if(arr[j]==MinNums[j])
                {
                    int temp=(length-j)*arr[j];
                    temp=temp%value;
                    result+=temp;
                    result=result%value;
                    break;
                }
                min=Math.min(arr[j],min);
                result+=min;
                result=result%value;
            }
            min=Integer.MAX_VALUE;
        }
        return result;
    }

    public int sumSubarrayMins1(int[] arr) {
        int length=arr.length;
        int left=0;
        int right=0;
        int result=0;
        final  int value=1000000007;
        for (int i=0;i<length;i++)
        {
            left=i;
            for (int j=i-1;j>=0;j--)
            {
                if (arr[i]<arr[j])
                {
                    left=j;
                }
                else
                {
                    break;
                }
            }
            for (int j=i;j<length;j++)
            {
                if (arr[i]<=arr[j])
                {
                    right=j;
                }
                else
                {
                    break;
                }
            }
            double i1 = arr[i] * (i - left + 1)* (right - i + 1)% value ;
            i1=i1* (right - i + 1)% value;
            result=(int) (result+i1)%value;
        }
        return result;
    }

    public int sumSubarrayMins2(int[] arr) {
        int length=arr.length;
        LinkedList<Integer> stackLeft=new LinkedList<>();
        LinkedList<Integer> stackRight=new LinkedList<>();
        int result=0;
        int left[]=new int[length];
        int right[]=new int[length];
        final int value=1000000007;
        for (int i=0;i<length;i++)
        {
            while (!stackLeft.isEmpty())
            {
                if (arr[i]<arr[stackLeft.getLast()])
                {
                    stackLeft.removeLast();
                }
                else break;
            }
            left[i]=stackLeft.isEmpty()?0:stackLeft.getLast()+1;
            stackLeft.addLast(i);
        }
        for (int i=length-1;i>=0;i--)
        {
            while (!stackRight.isEmpty())
            {
                if (arr[i]<=arr[stackRight.getLast()])
                {
                    stackRight.removeLast();
                }
                else break;
            }
            right[i]=stackRight.isEmpty()?length-1:stackRight.getLast()-1;
            stackRight.addLast(i);
        }
        for (int i=0;i<length;i++)
        {
            System.out.println(left[i]+":"+right[i]);
            double i1 = arr[i] * (i - left[i] + 1)% value ;
            i1=i1* (right[i] - i + 1)% value;
            result=(int) (result+i1)%value;
        }
        return result;
    }
    @Test
    public void test()
    {
        System.out.println(sumSubarrayMins2(new int[]{71,55,82,55}));
    }
}
