import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class getKthMagicNumber {
    //https://leetcode.cn/problems/get-kth-magic-number-lcci/
    public int getKthMagicNumber1(int k) {
        if (k==1) return 1;
        if (k==2) return 3;
        if (k==3) return 5;
        if (k==4) return 7;
        int num=4;
        int index=8;
        ArrayList<Boolean> list=new ArrayList<>();
        list.add(false);//0
        list.add(true);//0
        list.add(false);//0
        list.add(true);//0
        list.add(false);//0
        list.add(true);//0
        list.add(false);//0
        list.add(true);//0
        while (num<k)
        {
            if (index%2==0)
            {
                index++;
                list.add(false);
            }
            else
            {
                boolean flag1=false;
                boolean flag2=false;
                for (int j=(int)Math.pow(index,0.5);j>1;j--)
                {
                    if (index%j!=0) continue;
                    else
                    {
                        int temp=index/j;
                        if (j!=3&&j!=5&&j!=7&&!list.get(j))
                        {
                          //  list.add(false);
                            flag1=true;
                            break;
                        }
                        if (temp==3||temp==5||temp==7||list.get(temp))
                        {
                            flag2=true;
                            continue;
                        }
                        else
                        {
                          //  list.add(false);
                            flag1=true;
                            break;
                        }
                    }
                }
                if (!flag1&&flag2)
                {
                    list.add(true);
                    num++;
                //    if (num==k) return index;
                }
                else list.add(false);
                index++;
            }
        }
        return index-1;
    }
    @Test
    public void test()
    {
        System.out.println(getKthMagicNumber(16));
    }
//    [false, true, false, true, false, true, false, true, false, true, false, false,
////            false, false, false, true, false, false, false, false, false, true, false,
////            false, false, true, false, true, false, false, false, false, false, false,
////            false, false, true, false, false, false, false, false, false, false, false,
////            false, false, true, false, false, false, true, false, false, false, false,
////            false, false, false, false, false, false, false, false, false, false, false,
////            false, true, false, false, false, false, false, false, false, false, false,
////            false, false, false, false, true, false, false, false, false, false, false, true]

//    [false, true, false, true, false, true, false, true, false, true, false, false, false,
//            false, false, true, false, false, false, false, false, true, false, false, false,
//            true, false, true, false, false, false, false, false, false, false, false, true,
//            false, false, false, false, false, false, false, false, false, false, true, false,
//            false, false, true, false, false, false, false, false, false, false, false, false,
//            false, false, false, false, false, false, false, true, false, false, false, false,
//            false, false, false, false, false, false, false, false, false, true,false, false,
//            false, false, false, false, true, false, false, false, false, false, false, false,
//            false, false, false, false, false, false, false, false, false, false, false, false,
//            false, false, false, false, false, false, false, false, false, false, false, false,
//            false, false, false, false, false, false, false, false, false, false, false, false,
//            false, false, false, false, false, false, false, false, false, false, false, false,
//            false, true]
public int getKthMagicNumber(int k) {
    HashSet<Integer> set=new HashSet<>();
    set.add(1);
    int num=1;
    int index=2;
    while (num<k)
    {
            if (index%3==0)
            {
                if (set.contains(index/3))
                {
                    num++;
                    set.add(index);
                }
                index++;
                continue;
            }
            if (index%5==0)
            {
                if (set.contains(index/5))
                {
                    num++;
                    set.add(index);
                }
                index++;
                continue;
            }
            if (index%7==0)
            {
                if (set.contains(index/7))
                {
                    num++;
                    set.add(index);
                }
                index++;
                continue;
            }
            index++;
    }
    return index-1;
}

}
