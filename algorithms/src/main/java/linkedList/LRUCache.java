package linkedList;


import java.util.HashMap;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class LRUCache {


    private int capacity;
    /**
     * 为了实现这些操作，我们可以使用一个哈希表 (HashMap) 结合一个双向链表 (Doubly Linked List)：
     * 哈希表 用于在 O(1) 时间内定位缓存中的键。
     */
    private HashMap<Integer, Node> cache;
    /**
     *  伪头部和伪尾部：伪头部和伪尾部节点简化了边界条件的处理，使得插入和删除操作更加简洁。
     *  双向链表 用于维护键值对的使用顺序，链表头部表示最近使用的键，尾部表示最久未使用的键。
     */
    private Node head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 如果键存在于缓存中，则返回对应的值，否则返回 -1。
     * @param key
     * @return
     */
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        // 移动到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 插入新的键值对。如果键已经存在，则更新其值；如果键不存在，则插入新键值对，并在必要时移除最久未使用的键。
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            // 移动到头部
            moveToHead(node);
        } else {
            Node newNode = new Node(key,  value);
            cache.put(key, newNode);
            addToHead(newNode);
            if(cache.size() > capacity) {
                // 移除尾部节点
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void  addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}
