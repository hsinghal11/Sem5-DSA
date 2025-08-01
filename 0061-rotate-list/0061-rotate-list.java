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
        int c=0;
        ListNode temp=head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        if(c<=1 || k==0){
            return head;
        }
        k%=c;

        c=1;
        temp=head;
        while(c<=k){
            temp=temp.next;
            c++;
        }
        ListNode temp2=head;
        while(temp.next!=null){
            temp=temp.next;
            temp2=temp2.next;
        }
        temp.next=head;
        head=temp2.next;
        temp2.next=null;
        return head;
    }
}