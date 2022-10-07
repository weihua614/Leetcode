import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class sortList_148 {
    public ListNode sortList(ListNode head) {
        if (head==null) return null;
        LinkedList<Integer> list=new LinkedList<>();
        while (head!=null)
        {
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        head=new ListNode(list.removeFirst());
        ListNode temp=head;
        while (list.size()!=0)
        {
            ListNode listNode = new ListNode(list.removeFirst());
            temp.next=listNode;
            temp=temp.next;
        }
        return head;
    }
}
