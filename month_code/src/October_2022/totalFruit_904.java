package October_2022;

import org.junit.Test;

import java.util.HashMap;

public class totalFruit_904 {
    public int totalFruit1(int[] fruits) {
            int max=0;
            for (int i=0;i<fruits.length;i++)
            {
                if (i>0&&fruits[i]==fruits[i-1]) continue;
                int fruit1=fruits[i];
            int fruit2=0;
            int sum=1;
            for (int j=i+1;j<fruits.length;j++)
            {
                if (fruit1==fruits[i]||fruit2==fruits[i])
                {
                    sum++;
                }
                else if (fruit2==0&&fruits[i]!=fruit1)
                {
                    fruit2=fruits[i];
                    sum++;
                }
                else
                {
                    break;
                }
            }
            max=Math.max(sum,max);
                System.out.println(i);
        }
        return max;
    }
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=1;
        map.put(fruits[0],1);
        int sum=1;
        int max=0;
        while (left<fruits.length&&right<fruits.length)
        {
            if (map.size()<=2)
            {
                map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
                right++;
                sum++;
                if (map.size()<=2)
                {
                    max=Math.max(max,sum);
                }
            }
            else
            {
                Integer integer = map.get(fruits[left]);
                if (integer==1) map.remove(fruits[left]);
                else
                {
                    map.put(fruits[left],integer-1);
                }
                left++;
                sum--;
                if (map.size()<=2)
                {
                    max=Math.max(max,sum);
                }

            }
        }
        return max;
    }
    @Test
    public void test()
    {
        totalFruit(new int[]{1,0,3,4,3});
    }
}
