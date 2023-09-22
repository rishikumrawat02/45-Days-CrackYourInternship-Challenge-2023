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
    public ListNode partition(ListNode head, int x) {
        ListNode fNHead=null; ListNode fN=null; ListNode sNHead=null; ListNode sN=null;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                if(fN==null){
                    fNHead=fN=cur;
                }
                else{
                    fN.next=cur; fN=cur;
                }
            }else{
                if(sN==null) sNHead=sN=cur;
                else{
                    sN.next=cur; sN=cur;
                }
            }
            cur=cur.next;
        }
        if(fN==null) return sNHead;
        if(sN!=null) sN.next=null;
        fN.next=sNHead; 
        return fNHead;
    }
}
