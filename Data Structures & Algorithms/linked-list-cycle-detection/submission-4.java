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
    public boolean hasCycle(ListNode head) {
        
        ListNode first = head;
        ListNode end = head;

        while(end != null && end.next != null){
            first = first.next;
            end = end.next.next;

            if(first == end){
                return true;
            }
        }
        return false;
    }
}
