package Leetcode.challenge.Algorithms;

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeKLists {
    public MergeKLists() {
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <= 0)
            return null;
        ListNode finalList = lists[0];
        for(int i=1 ; i < lists.length  ; i++)
        {
            finalList = mergeTwoLists(finalList,lists[i]);
        }
        return finalList;
    }
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
