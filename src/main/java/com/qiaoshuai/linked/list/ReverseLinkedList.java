package com.qiaoshuai.linked.list;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 206. 反转链表-迭代的方式
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode tempPre = null;//用来保存当前节点的前一个指针，也就是当前节点的next指针
        ListNode tempIteration = head;
        while(tempIteration != null){
            ListNode ccc=   tempIteration.next;
            tempIteration.next = tempPre;
            tempPre = tempIteration;
            tempIteration =ccc;
        }
        return tempPre;
    }
    /**
     * 206. 反转链表-递归方式
     * @param head
     * @return
     */
    public ListNode reverseListV2(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return  temp;
    }
}
