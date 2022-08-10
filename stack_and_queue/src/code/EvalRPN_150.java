package code;

import jdk.nashorn.internal.ir.CaseNode;

import java.util.HashMap;
import java.util.LinkedList;

public class EvalRPN_150 {
    public int evalRPN(String[] tokens) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        map.put("+",0);
        map.put("-",1);
        map.put("*",2);
        map.put("/",3);
        for(String tem:tokens)
        {
            if(!map.containsKey(tem))
            {
                stack.add(Integer.parseInt(tem));
            }
            else
            {
                Integer num1 = stack.removeLast();
                Integer num2 = stack.removeLast();
                switch (map.get(tem))
                {
                    case 0:
                        stack.add(num2+num1);
                        break;
                    case 1:
                        stack.add(num2-num1);
                        break;
                    case 2:
                        stack.add(num2*num1);
                        break;
                    case 3:
                        stack.add(num2/num1);
                        break;
                }
            }
        }
        return stack.getFirst();
    }

    public static void main(String[] args) {
        EvalRPN_150 evalRPN_150 = new EvalRPN_150();
        System.out.println(evalRPN_150.evalRPN(new String[]{"4","3","-"}));
    }
}
