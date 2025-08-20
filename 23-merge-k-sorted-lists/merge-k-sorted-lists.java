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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode Dummy = new ListNode();
        ListNode temp = Dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode r = pq.poll();
            Dummy.next = r;
            Dummy = Dummy.next;
            if(r.next != null){
                pq.add(r.next);
            }
        }
        return temp.next;
    }
}