import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class maximumSwap_670 {
    public int maximumSwap(int num) {
       // int result=0;
        String strNum=(num+"");
        int length=strNum.length();
        Integer index[]=new Integer[length];
        Integer value[]=new Integer[length];
        int temp=num;
        for(int i=length-1;i>=0;i--)
        {
            index[i]=i;
            value[i]=temp%10;
            temp=temp/10;
            System.out.println(index[i]+":"+value[index[i]]);
        }
        System.out.println();
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(value[o1]==value[o2])
                {
                    return o2-o1;
                }

               return  -(value[o1]-value[o2]);
            }
        });
        for(int i=0;i<length;i++)
        {
            System.out.println(index[i]+":"+value[index[i]]);
        }
        int i=0;
        while(i<length)
        {
            if(i!=index[i])
            {
                if(value[i]!=value[index[i]])
                {
                    break;
                }
                else
                {

                    index[i+1]=index[i];
                    i++;
                }
            }
            else
            {
                i++;
            }
        }
        if(i>=length) return num;
        else
        {
            char[] chars = strNum.toCharArray();
            char tem1=chars[i];
            char tem2=chars[index[i]];
            chars[i]=tem2;
            chars[index[i]]=tem1;
            return Integer.valueOf(new String(chars));

        }
    }


    @Test
    public void test()
    {
        /////////////////0123456  5104632
        System.out.println(maximumSwap(98368));
    }
}
