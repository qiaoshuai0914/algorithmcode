package com.qiaoshuai.linked.list;

import com.qiaoshuai.entry.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode falst = head.next;
        while (slow!=falst){
            if(falst == null || falst.next==null){
                return false;
            }
            slow=slow.next;
            falst=falst.next.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
