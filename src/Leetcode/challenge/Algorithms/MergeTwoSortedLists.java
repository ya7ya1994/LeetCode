package Leetcode.challenge.Algorithms;
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
    }
}
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalList = new ListNode();
        ListNode temp = finalList;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }

            temp = temp.next;
        }

        return finalList.next;

    }
}
