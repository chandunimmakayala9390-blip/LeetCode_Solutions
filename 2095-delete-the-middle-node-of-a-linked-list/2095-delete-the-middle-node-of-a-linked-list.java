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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count/2;
        count = 0;
        ListNode prev = head;
        temp = head;
        while(count != mid) {
            prev = temp;
            count++;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
}