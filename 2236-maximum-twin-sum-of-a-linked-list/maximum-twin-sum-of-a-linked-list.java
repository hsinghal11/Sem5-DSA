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
    public int pairSum(ListNode head) {
        int sum = 0;
        ArrayList<Integer> ll = new ArrayList<>();
        while(head != null) {
            ll.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = ll.size()-1;
        while(i<=j){
            sum = Math.max(ll.get(i) + ll.get(j) , sum);
            i++;
            j--;
        }
        return sum;
    }
}