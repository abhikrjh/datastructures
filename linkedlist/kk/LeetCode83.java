package linkedlist.kk;
/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/

public class LeetCode83 {

    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
//        Input: head = [1,1,2,3,3]

        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode nextUniqueNode = head.next;

        while (nextUniqueNode != null) {

            if (curNode.val == nextUniqueNode.val) {
                nextUniqueNode = nextUniqueNode.next;
                continue;
            }

            curNode.next = nextUniqueNode;
            curNode = nextUniqueNode;
            nextUniqueNode = nextUniqueNode.next;
        }

        curNode.next = null; // We need to point last unique node to null

        return head;
    }

}
