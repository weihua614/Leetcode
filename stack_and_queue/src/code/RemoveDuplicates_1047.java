package code;

import java.util.LinkedList;

public class RemoveDuplicates_1047 {

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
                if(stack.isEmpty()||stack.getLast()!=chars[i])
                {
                    stack.add(chars[i]);
                }
                else stack.removeLast();
        }
        StringBuilder result=new StringBuilder(stack.size());
        for(Character temp:stack){
            result.append(temp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates_1047 removeDuplicates_1047=new RemoveDuplicates_1047();
        System.out.println(removeDuplicates_1047.removeDuplicates("abbadgd"));
    }
}
