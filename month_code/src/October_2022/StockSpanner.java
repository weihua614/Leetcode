package October_2022;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class StockSpanner {
    ArrayList<Integer> list;
    ArrayList<Integer> nums;
    public StockSpanner() {
        list=new ArrayList<>();
    }

    public int next(int price) {
        int index=list.size()-1;
        while (index>=0)
        {
            if (list.get(index)<=price)
            {
                if (index>0)
                index=index-nums.get(index-1);
                else index--;
            }
            else
                break;
        }
        list.add(price);
        int i = list.size() - index-1;
        nums.add(i);
        return i;
    }

    LinkedList<Pair<Integer,Integer>> list1=new LinkedList<>();
    int index;
    public void StockSpanner1() {
        list1.addLast(new Pair<>(-1,Integer.MAX_VALUE));
        index=0;
    }
    public int next1(int price) {
       while (true)
       {
           if (price>list1.getLast().getValue())
           {
               list1.removeLast();
           }
           else
           {
               break;
           }
       }
       int result=index-list1.getLast().getKey();
       list1.addLast(new Pair<>(index,price));
       index++;
       return result;
    }
}
