package com.qiaoshuai.linked.list;

import com.qiaoshuai.entry.ListNode;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapNodesinPairs24 {
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode current = head;

        ListNode previous = null;
        while (current != null && current.next != null) {
            ListNode temp = current.next.next;
            ListNode next = current.next;
            if (previous != null) {
                previous.next = next;
            }
            current.next = temp;
            next.next = current;
            previous = current;
            current = temp;
        }
        return result;
    }

    /**
     * 递归处理 通反转链表类似的思想
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //本层要处理的逻辑
        ListNode newHead = head.next;
        //进入下一层
        head.next = swapPairs2(head.next.next);
        //下一层返回以后本层要处理的逻辑
        newHead.next = head;
        return newHead;
    }
}
