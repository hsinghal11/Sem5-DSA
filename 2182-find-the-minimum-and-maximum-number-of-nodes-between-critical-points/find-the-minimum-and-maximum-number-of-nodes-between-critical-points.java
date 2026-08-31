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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];
        ArrayList<Integer> idxx = new ArrayList<>();
        int prev = head.val;
        int i = 2;
        head = head.next;
        while (head.next != null){
            if(head.val < prev && head.val < head.next.val){
                idxx.add(i);
            }
            if(head.val > prev && head.val > head.next.val){
                idxx.add(i);
            }
            i++;
            prev = head.val;
            head = head.next;
        }
        if(idxx.size() < 2) return new int[]{-1,-1};
        ans[1] = idxx.get(idxx.size()-1) - idxx.get(0);
        ans[0] = Integer.MAX_VALUE;
        for(int idx=0; idx<idxx.size()-1; idx++){
            if(idxx.get(idx+1) - idxx.get(idx) < ans[0]) ans[0] = idxx.get(idx+1) - idxx.get(idx);
        }
        return ans;
    }
}