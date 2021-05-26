package com.qiaoshuai.linked.list;

import java.util.HashMap;


/**
 * 简单的可以用LinkedHashMap  里面就是维护双向链表和哈希表
 *
 */
public class LRUCache {
        //保存缓存，为了get 时间复杂度在O(1)中
        private HashMap<Integer,CacheNode>  map = new HashMap();
        //双向链表  为了保存热数据
        private CacheNode  head,tail;
        //最大容量
        private int maxCapacity;
        // 当时保存的多少个数据
        private int size;
        public LRUCache(int capacity) {
            this.size =0;
            this.maxCapacity = capacity;
            this.head = new CacheNode();
            this.tail = new CacheNode();
            head.next =tail;
            tail.prev = head;

        }

        public int get(int key) {
            CacheNode node = map.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;

        }

    /**
     * 第一步：从map中获取key的值，
     * 第二：判断是存在
     * 第三：存在则把值替换，同时把节点放入head.next中
     * 第四；不存在，则简历新的CahceNode节点 放入map ，size加一，然后放入头部head.next中  然后判断是否超过容量
     * 第五：超过，删除最有一个；同时map中删除
     * @param key
     * @param value
     */
        public void put(int key, int value) {
            CacheNode node = map.get(key);
            if(node==null){
                node = new CacheNode();
                node.key = key;
                node.value = value;
                map.put(key,node);
                addHead(node);
                size++;
                if(size>maxCapacity){
                    CacheNode a = removeTail();
                    map.remove(a.key);
                    size--;
                }
            }else{
                node.value =value;
                moveToHead(node);
            }

        }
        //涉及的操作   删除一个节点 ，增加一个节点，删除尾节点；
        private  CacheNode removeTail(){
            CacheNode temp =tail.prev;
            removeNode(temp);
            return temp;

        }
        private void removeNode(CacheNode node){
            node.prev.next =node.next;
            node.next.prev = node.prev;
        }
        private void addHead(CacheNode node){
            //先处理后一个节点 在处理头部节点
            head.next.prev= node;
            node.next=head.next;
            head.next = node;
            node.prev =head;
        }
        private void moveToHead(CacheNode node){
            //1删除原来的位置；
            //把当前节点放到head.next = node;
            removeNode(node);
            addHead(node);

        }
        class CacheNode{
            int key;
            int value;
            CacheNode  prev;
            CacheNode  next;
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
