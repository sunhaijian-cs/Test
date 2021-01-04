package algo.lc.datastructure;

import java.util.HashMap;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/13
 * @Description:
https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/lru-suan-fa
LRU 缓存淘汰算法就是一种常用策略。LRU 的全称是 Least Recently Used，也就是说我们认为最近使用过的数据应该是是「有用的」，
很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。

分析上面的操作过程，要让 put 和 get 方法的时间复杂度为 O(1)，我们可以总结出 cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。

因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；而且我们要在 cache 中查找键是否已存在；
如果容量满了要删除最后一个数据；每次访问还要把数据插入到队头。

那么，什么数据结构同时符合上述条件呢？
哈希表查找快，但是数据无固定顺序；
链表有顺序之分，插入删除快，但是查找慢。
所以结合一下，形成一种新的数据结构：哈希链表。

LRU 缓存算法的核心数据结构就是哈希链表：双向链表和哈希表的结合体。

 **/
public class Last_Recently_Used {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public Last_Recently_Used(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }

}




class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

/**
 * 双向链表实现
 */
class DoubleList {
    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x){}

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x){}

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast(){ return null;}

    // 返回链表长度，时间 O(1)
    public int size(){ return 0;}
}