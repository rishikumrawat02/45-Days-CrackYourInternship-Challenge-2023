class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=null; ListNode cur=head;
        while(cur!=null){
            if(prev!=null && cur.val==prev.val){
                prev.next=null; 
            }else if(prev==null){
                prev=cur;
            }else{
                prev.next=cur;
                prev=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
