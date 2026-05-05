/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Find size and last node
        ListNode temp = head;
        int size = 1;

        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: Make circular
        temp.next = head;

        // Step 3: Effective rotations
        k = k % size;
        int steps = size - k;

        // If no rotation needed
        if (k == 0) {
            temp.next = null;
            return head;
        }

        // Step 4: Find new tail
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set new head
        ListNode newHead = newTail.next;

        // Step 6: Break circle
        newTail.next = null;

        return newHead;
    }
}