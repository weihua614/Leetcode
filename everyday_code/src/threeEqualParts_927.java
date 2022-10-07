import org.junit.Test;

public class threeEqualParts_927 {
    public int[] threeEqualParts(int[] arr) {
        int oneNums=0;
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]==1)
            {
                oneNums++;
            }
        }
        if (oneNums==0)return new int[]{0,2};
        if(oneNums%3!=0) return new int[]{-1,-1};
        oneNums=oneNums/3;
        int zeroNums=0;
        for (int i=arr.length-1;i>=0;i--)
        {
            if (arr[i]==0) zeroNums++;
            else break;
        }
        int one=-1;int two=-1;

        int index=0;
        while (index<arr.length)
        {
            int twoNums=oneNums;
            int temp=zeroNums;
            while (twoNums>0)
            {
                if (arr[index]==1)
                {
                    twoNums--;
                }
                index++;
            }
            while (temp>0)
            {
                if (arr[index]!=0)
                {
                    return new int[]{-1,-1};
                }
                else {
                    index++;
                    temp--;
                }
            }
            if (one==-1)
            {
                one=index;
            }
            else if (two==-1)
            {
                two=index;
                break;
            }
        }
        if (erjinzhi(arr,one,two-1,two,arr.length-1)&&erjinzhi(arr,0,one-1,one,two-1))
        {
            return new int[]{one-1,two};
        }
        else return new int[]{-1,-1};
    }
    public boolean erjinzhi(int []arr,int left1,int right1,int left2,int right2)
    {
        while (left1<right1)
        {
            if (arr[left1]==0)
                left1++;
            else break;
        }
        while (left2<right2)
        {
            if (arr[left2]==0)
                left2++;
            else break;
        }
        if (left1==right1&&left2==right2) return arr[left1]==arr[left2];
        if (right1-left1!=right2-left2)return false;
        for (int i=left1;i<=right1;i++)
        {
            if (arr[left1]!=arr[left2]) return false;
            left1++;
            left2++;
        }
        return true;
    }
    @Test
    public void test()
    {
        //                         0 1 2 3 4 5 6 7 8 9
        threeEqualParts(new int []{1,1,1,1,1,1,0,1,1,1});
    }
}
