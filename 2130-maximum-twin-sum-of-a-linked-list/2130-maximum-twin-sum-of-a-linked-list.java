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
import java.util.ArrayList;
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> lis = new ArrayList<>();
        if(head==null)return 0;
        ListNode temp=head;
        while(temp != null){
            lis.add(temp.val);
            temp = temp.next;
        }
        int left = 1, right = lis.size()-2;
        int ans = lis.get(0)+lis.get(lis.size()-1);
        while(left < right){
            ans = Math.max(ans,lis.get(left) + lis.get(right));
            left++;
            right--;
        }
        return ans;
    }
}