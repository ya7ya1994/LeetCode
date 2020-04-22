package Leetcode.challenge.Algorithms;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*ListNode objcet11 = new ListNode(1);
        ListNode objcet12 = new ListNode(9);
        ListNode objcet13 = new ListNode(9);
        ListNode objcet14 = new ListNode(9);
        ListNode objcet15 = new ListNode(9);
        ListNode objcet16 = new ListNode(9);
        ListNode objcet17 = new ListNode(9);
        ListNode objcet18 = new ListNode(9);
        ListNode objcet19 = new ListNode(9);
        ListNode objcet20 = new ListNode(9);


        objcet11.next = objcet12;
        objcet12.next = objcet13;
        objcet13.next = objcet14;
        objcet14.next = objcet15;
        objcet15.next = objcet16;
        objcet16.next = objcet17;
        objcet17.next = objcet18;
        objcet18.next = objcet19;
        objcet19.next = objcet20;


        ListNode objcet21 = new ListNode(5);
        ListNode objcet22 = new ListNode(6);
        ListNode objcet23 = new ListNode(4);
        objcet21.next = objcet22;
        objcet22.next = objcet23;
        objcet23.next = null;


        Solution4 s1 = new Solution4();*/
        //System.out.println(s1.lenght(objcet11));
        //System.out.println(s1.lenght(objcet21));
        //System.out.println(String.valueOf(s1.addTwoNumbers(objcet11,objcet21)));
        //System.out.println(10%10);
        //String test="dvdf";
        //System.out.println(test.substring(0));
        //System.out.println(s1.lengthOfLongestSubstring("davdf"));
        //System.out.println(s1.canWinNim(4));
        /*ArrayList<String> result = new ArrayList<>();
        result=s1.popularNFeatures(5,2,)
        for(int i =0;i<2;i++)
        {
            System.out.println();
        }
*/
        /*String test = "This is just a test to see if this test is working or not";
        List<String> input = new ArrayList<>();
        input.add("This is just a test to see if this test is working or not");
        input.add("This is just a test to see if this test is working or not");
        input.add("This is just a rest to see if this test is working or not");
        input.add("This is just a best to see if this best is working or not");
        input.add("This is just a rest to see if this rest is working or not");
        input.add("This is just a test to see if this test is working or not");
        input.add("This is just a test to see if this test is working or not");
        input.add("This is just a rest to see if this rest is working or not");
        input.add("This is just a Guest to see if this Guest is working or not");
        input.add("This is just a best to see if this best is working or not");
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("best");
        list.add("Guest");
        list.add("rest");
        s1.popularNFeatures(4, 2, list, 10, input);
        for(String topRequests : s1.popularNFeatures(4, 2, list, 10, input) )
        {
            System.out.println(topRequests);
        }*/
        //["LRUCache","put","put","put","put","get","get"]
        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        /*LRUCache3 cache = new LRUCache3( 2 *//* capacity *//* );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));*/
        //Solution5 s = new Solution5();
        //s.longestPalindrome("bacekbkecad");

       /* ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Problem15 p = new Problem15();
        p.removeNthFromEnd(l1,2);*/
        /*int total = 0;
        int first = 50000;
        for (int i = 0; i < 20; i++) {
            total += first;
            first += 50000;
        }
        first = 1000000;
        for (int i = 0; i < 3; i++) {
            total += first;
            first += 1000000;
        }
        total+=8000000;
        System.out.println(total);
        {

        }*/
        //Solution6 s = new Solution6();
        //String s1 = "abbaghhghh";
       // System.out.println(s1.substring(1,9));
        //System.out.println(s.longestPalindrome(s1));
        /*String a[] = {"eat"};
                //,"tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams s = new GroupAnagrams();
        //s.groupAnagrams(a);
        for (List<String> i: s.groupAnagrams(a))
        {
            System.out.println("\t");
            for (String j : i)
            {
                System.out.println(j);
            }
        }*/
        int[][] input = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        MergeIntervals m = new MergeIntervals();
        int[][] output = m.merge(input);
        for( int i=0 ; i < output.length ; i++)
            for( int j=0 ; j < 2 ; j++)
        System.out.println(output [i][j]);
    }
}
