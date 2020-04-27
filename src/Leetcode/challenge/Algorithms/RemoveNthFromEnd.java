package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.List;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Follow up:
        //Could you do this in one pass?
        ListNode finalList = head;
        int size = 0;
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
            size++;
        }
        listNodes.add(null);
        if (size == n) {
            finalList = finalList.next;
            return finalList;
        }
        listNodes.get(size - n - 1).next = listNodes.get(size - n + 1);
        return finalList;
       /*  Second Method
       ListNode finalList = head;
       ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        if (size == n) {
            finalList = finalList.next;
            return finalList;
        }
        int reverseIndex = size;
        while (reverseIndex > n) {
            temp = head;
            head = head.next;
            reverseIndex--;
        }
        temp.next = head.next;
        head = null;
        return finalList;*/
        /* Method 3
        public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)
        return null;
 
    ListNode fast = head;
    ListNode slow = head;
 
    for(int i=0; i<n; i++){
        fast = fast.next;
    }
 
    //if remove the first node
    if(fast == null){
        head = head.next;
        return head;
    }
 
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
 
    slow.next = slow.next.next;
 
    return head;*/
}
    }
}
