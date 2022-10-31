package October_2022;

import java.util.LinkedList;

public class countStudents_1700 {
    public int countStudents(int[] students, int[] sandwiches) {

        /*
        students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
                    1 1 0 0 1                    0 0 0 1 1
                    10011
                    00111
                    0111                           0011
                    111                            011
         */

        int Zero=0;
        LinkedList<Integer> list=new LinkedList<>();
        for (int i:students)
        {
            list.addLast(i);
            if (i==0) Zero++;
        }
        int index=0;
        while (list.size()>0)
        {
            if (list.getFirst()==sandwiches[index])
            {
                list.removeFirst();
                if (sandwiches[index]==0) Zero--;
                index++;
            }
            else
            {
                if (Zero!=0&&Zero!=list.size())
                {
                    list.addLast(list.removeFirst());
                }
                else
                {
                    break;
                }
            }
        }
        return list.size();
    }
}
