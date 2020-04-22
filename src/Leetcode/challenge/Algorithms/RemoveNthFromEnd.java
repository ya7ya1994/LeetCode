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
    }
}
