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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Dummy node acts as the start anchor for our sorted list
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        
        while (curr != null) {
            // Store the next node to process since curr.next will be modified
            ListNode nextNode = curr.next;
            
            // Start searching for the insertion spot from the dummy node
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;
            
            // Move to the next node in the original list
            curr = nextNode;
        }
        
        return dummy.next;
    }
}
