package MediumDifficulty;

import java.util.HashMap;

public class p146 {
    class MapLinkedList{                            // 键值对链表 head<0, 0> <--> <key1, value1> <--> <key2, value2> <--> <key3, value3>
        int key;
        int value;
        MapLinkedList pre;
        MapLinkedList next;
        public MapLinkedList(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    private int len;                                       //记录输入的链表长度
    private HashMap<Integer, MapLinkedList> indexMap;      //Map记录key和对应的MapLinkedList(我一开始记录 key和对应的MapLinkedList所在链表中的索引，真是蠢)
    private MapLinkedList head;                             //链表头节点
    public p146(int capacity) {                         //初始化
        this.len = capacity;
        this.indexMap = new HashMap<>();
        this.head = new MapLinkedList(0, 0);
        head.next = head;
        head.pre = head;
    }

    public void addHead(MapLinkedList Node){        //当前key值的节点未存在在链表中，将Node直接加入到链表头
        Node.next = this.head.next;
        Node.pre = this.head;
        if(this.head.next != null)
            this.head.next.pre = Node;
        this.head.next = Node;
    }

    public void removeAdd(MapLinkedList Node){      //当前key值的节点已经存在在链表中，先将Node从链表中取出，再加入到链表头
        Node.pre.next = Node.next;
        Node.next.pre = Node.pre;

        Node.next = this.head.next;
        Node.pre = this.head;
        if(this.head.next != null)
            this.head.next.pre = Node;
        this.head.next = Node;
    }

    public int get(int key) {
        if(this.indexMap.containsKey(key)) {
            removeAdd(this.indexMap.get(key));
            return this.indexMap.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (this.indexMap.containsKey(key)) {                       //考虑当前key值是否已经存在于链表中
            MapLinkedList oldNode = this.indexMap.get(key);         //是：替换当前value为新的value
            oldNode.value = value;
            removeAdd(oldNode);
        } else {
            if (this.indexMap.size() == len){                       //否：考虑当前链表的长度是否达到最大值
                MapLinkedList oldNode = this.head.pre;                //是：取出表尾节点，将新节点加入表头
                indexMap.remove(oldNode.key);
                oldNode.key = key;
                oldNode.value = value;
                indexMap.put(key, oldNode);
                removeAdd(oldNode);
            }
            else {                                                    //否：直接将新节点加入表头
                MapLinkedList newNode = new MapLinkedList(key, value);
                addHead(newNode);
                indexMap.put(key, newNode);
            }
        }
//        MapLinkedList temp = head.next;
        //   while(temp != head){
        //       System.out.println(temp.key);
        //       temp = temp.next;
        //   }
        //  System.out.println(indexMap);
        //  System.out.println("11111111111111");
    }
}
