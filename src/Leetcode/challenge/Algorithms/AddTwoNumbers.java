package Leetcode.challenge.Algorithms;

import java.math.BigInteger;
import java.util.LinkedList;

public class AddTwoNumbers {

    public AddTwoNumbers() {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getListNode(getNumber(l1).add(getNumber(l2)));
    }

    public BigInteger getNumber(ListNode l1) {
        BigInteger number = new BigInteger(String.valueOf(l1.val));
        int i = 1;
        l1 = l1.next;
        while (l1 != null) {
            BigInteger temp = BigInteger.valueOf((long) ((l1.val) * Math.pow(10, i)));
            number=number.add(temp);
            i++;
            l1 = l1.next;
        }
        return number;

    }

    public ListNode getListNode(BigInteger number) {
        String num = number.toString();
        System.out.println(num.length());
        ListNode node  = new ListNode(Integer.parseInt(String.valueOf(num.charAt(num.length() - 1))));
        ListNode result = node;
        int i = num.length() - 2;
        while (i >= 0) {
            ListNode n = new ListNode(Integer.parseInt(String.valueOf(num.charAt(i))));
            node.next = n;
            node = node.next;
            i--;
        }
        return result;
    }


}