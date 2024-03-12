/*
 * 328. Odd Even Linked List
 * [https://leetcode.com/problems/odd-even-linked-list/description/]
 */

package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode nd = oddEvenList(n1);
        while (nd != null) {
            System.out.print(nd.val + " ");
            nd = nd.next;
        }
        System.out.println();
    }

    static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode newNode = new ListNode();
        ListNode counterNode = newNode;
        ListNode n1 = head;
        ListNode n2 = head.next;

        while (n1 != null) {
            counterNode.next = new ListNode(n1.val);
            counterNode = counterNode.next;
            if (n1.next == null)
                break;
            n1 = n1.next.next;
        }
        while (n2 != null) {
            counterNode.next = new ListNode(n2.val);
            counterNode = counterNode.next;
            if (n2.next == null)
                break;
            n2 = n2.next.next;
        }
        return newNode.next;

    }

}
