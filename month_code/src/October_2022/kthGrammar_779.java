package October_2022;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class kthGrammar_779 {
    public int kthGrammar(int n, int k) {
        /*
        1  0          0    1
        2  01         1    2
        3  01 10       6    4
        4  0110 1001        8
        5  01101001 10010110 16
         */
        int result;
        if (n==1) return 0;

            if (k<=Math.pow(2,n-2))
            result=kthGrammar(n-1,k);
            else result=kthGrammar(n-1,(int)(k-Math.pow(2,n-2)))^1;
        return result;
//        ArrayList<Integer> list=new ArrayList<>(2<<(n-1));
//        int index=2;
//        list.add(0);
//        while (index<=n)
//        {
//            int nums=list.size();
//            for (int i=nums;i<2*nums;i++)
//            {
//                list.add(list.get(i-nums)^1);
//            }
//            index++;
//        }
//        return list.get(k);

    }

    public int kthGrammar1(int n, int k,boolean flag) {
        int result;
        if (n==1)
        {
            if (flag) return 0;
            else  return 1;
        }
        if (k<Math.pow(2,n-2))
        {
            result=kthGrammar1(n-1,k,flag);
        }
        else
        {
            result=kthGrammar1(n-1,(int)(Math.pow(2,n-1)-k),!flag);
        }
        return result;
    }

    @Test
    public void test()
    {
        kthGrammar(5,2);
    }


}
