/*
 * 21. Merge Two Sorted Lists
 * [https://leetcode.com/problems/merge-two-sorted-lists/description/]
 */

package LinkedList;

class MergeTwoSortedList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-10);
        ListNode n3 = new ListNode(-9);
        ListNode n4 = new ListNode(-4);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(6);
        ListNode l4 = new ListNode(-7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode nd = mergeTwoLists(n1, l4);
        while (nd != null) {
            System.out.print(nd.val + " ");
            nd = nd.next;
        }
        System.out.println();
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode counter1 = list1;
        ListNode counter2 = list2;
        ListNode dumNode = new ListNode();
        ListNode dumCounter = dumNode;

        while (counter1 != null && counter2 != null) {
            if (counter1.val < counter2.val) {
                dumCounter.next = counter1;
                dumCounter = counter1;
                counter1 = counter1.next;
            } else {
                dumCounter.next = counter2;
                dumCounter = counter2;
                counter2 = counter2.next;
            }
        }

        if (counter1 != null) {
            dumCounter.next = counter1;
        }
        if (counter2 != null) {
            dumCounter.next = counter2;
        }
        return dumNode.next;
    }
}