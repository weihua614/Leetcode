package code;

import java.util.LinkedList;
import java.util.List;

public class MyStack_255 {
    public LinkedList<Integer> queue1;
    public LinkedList<Integer> queue2;
    public MyStack_255() {
        queue1=new LinkedList<Integer>();
        queue2=new LinkedList<Integer>();

    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while(!queue1.isEmpty())
        {
            Integer temp = queue1.getFirst();
            queue1.removeFirst();
            if(queue1.isEmpty())
            {
                queue1=queue2;
                queue2=new LinkedList<Integer>();
                return temp;
            }
            queue2.add(temp);
        }
        return 0;
    }

    public int top() {
        while(!queue1.isEmpty())
        {
            Integer temp = queue1.getFirst();
            queue1.removeFirst();
            if(queue1.isEmpty())
            {
                queue2.add(temp);
                queue1=queue2;
                queue2=new LinkedList<Integer>();
                return temp;
            }
            queue2.add(temp);
        }
        return 0;
    }

    public boolean empty() {
        if(queue1.isEmpty()) return true;
        else return false;
    }
}
