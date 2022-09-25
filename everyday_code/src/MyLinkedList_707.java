import java.util.LinkedList;

public class MyLinkedList_707 {
    LinkedList<Integer> list=new LinkedList<>();
    public MyLinkedList_707() {

    }

    public int get(int index) {
        if(index>=list.size()-1) return -1;
        return list.get(index);
    }

    public void addAtHead(int val) {
        list.addFirst(val);
    }

    public void addAtTail(int val) {
        list.addLast(val);
    }

    public void addAtIndex(int index, int val) {
        if(index>list.size()) return;
        if(index<0) list.addFirst(val);
        else list.add(index,val);
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=list.size()) return;
        list.remove(index);
    }
}
