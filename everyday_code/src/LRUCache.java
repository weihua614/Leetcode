import org.junit.Test;

import java.util.*;

class LRUCache {

//    int capa;
//    HashMap<Integer,Integer> map=new HashMap<>();
//    ArrayList<Integer> list=new ArrayList<>();
//    public LRUCache(int capacity) {
//        capa=capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key))
//        {
//            for (int i=0;i<list.size();i++)
//            {
//                if (list.get(i)==key)
//                {
//                    list.remove(i);
//                    break;
//                }
//            }
//            list.add(key);
//            return map.get(key);
//        }
//        else return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key))
//        {
//            for (int i=0;i<list.size();i++)
//            {
//                if (list.get(i)==key)
//                {
//                    list.remove(i);
//                    break;
//                }
//            }
//            list.add(key);
//            map.put(key,value);
//            return;
//        }
//        if (list.size()>=capa)
//        {
//            Integer integer = list.remove(0);;
//            map.remove(integer);
//        }
//        map.put(key,value);
//        list.add(key);
//    }
//}
//
// class LRUCache1 {
//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//        public DLinkedNode() {}
//        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
//    }
//
//    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
//    private int size;
//    private int capacity;
//    private DLinkedNode head, tail;
//
//    public LRUCache1(int capacity) {
//        this.size = 0;
//        this.capacity = capacity;
//        // 使用伪头部和伪尾部节点
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            return -1;
//        }
//        // 如果 key 存在，先通过哈希表定位，再移到头部
//        moveToHead(node);
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            // 如果 key 不存在，创建一个新的节点
//            DLinkedNode newNode = new DLinkedNode(key, value);
//            // 添加进哈希表
//            cache.put(key, newNode);
//            // 添加至双向链表的头部
//            addToHead(newNode);
//            ++size;
//            if (size > capacity) {
//                // 如果超出容量，删除双向链表的尾部节点
//                DLinkedNode tail = removeTail();
//                // 删除哈希表中对应的项
//                cache.remove(tail.key);
//                --size;
//            }
//        }
//        else {
//            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
//            node.value = value;
//            moveToHead(node);
//        }
//    }
//
//    private void addToHead(DLinkedNode node) {
//        node.prev = head;
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
//    }
//
//    private void removeNode(DLinkedNode node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//    private void moveToHead(DLinkedNode node) {
//        removeNode(node);
//        addToHead(node);
//    }
//
//    private DLinkedNode removeTail() {
//        DLinkedNode res = tail.prev;
//        removeNode(res);
//        return res;
//    }


        LinkedHashMap<Integer, Integer> map;
        int nums=0;
        int capacity=0;
         public LRUCache(int capacity) {
             map=new LinkedHashMap<>();
             this.capacity=capacity;
         }

         public int get(int key) {
             if (map.containsKey(key))
             {
                 Integer remove = map.remove(key);
                 map.put(key,remove);
                 return remove;
             }
             else return -1;
         }

         public void put(int key, int value) {
             if (map.containsKey(key))
             {
                 map.remove(key);
                 map.put(key,value);
                 return;
             }
             if (nums>=capacity)
             {
                 for (int i : map.keySet()) {
                     map.remove(i);
                    // nums--;
                     break;
                 }
             }
             map.put(key,value);
             nums++;
         }

    public static void main(String[] args) {
        LRUCache lruCache2 = new LRUCache(2);
        lruCache2.put(1,1);
        lruCache2.put(2,2);
        lruCache2.get(1);
        lruCache2.put(3,3);
        lruCache2.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */