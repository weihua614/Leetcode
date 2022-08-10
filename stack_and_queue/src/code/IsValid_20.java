package code;

import java.util.HashMap;
import java.util.LinkedList;

public class IsValid_20 {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        LinkedList<Character> stack=new LinkedList();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i]))
            {
                stack.add(map.get(chars[i]));
            }
            else
            {
                if(stack.isEmpty()||chars[i]!=stack.getLast()) return false;
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid_20 isValid_20 = new IsValid_20();
        System.out.println(isValid_20.isValid("{[()]}"));
    }
}
