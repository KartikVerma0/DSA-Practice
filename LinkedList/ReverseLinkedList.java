
/*
 * 206. Reverse Linked List
 * [https://leetcode.com/problems/reverse-linked-list/description/]
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

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode rev = reverseList(n1);
        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
        System.out.println();
    }

    static ListNode newHead = new ListNode();

    static void setNewHead(ListNode n1) {
        newHead = n1;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        reverse(head, null, newHead);
        return newHead;
    }

    static ListNode reverse(ListNode current, ListNode previous, ListNode newNode) {
        if (current.next == null) {
            current.next = previous;
            setNewHead(current);
            return previous;
        }
        reverse(current.next, current, newNode).next = previous;
        return previous;
    }
}
