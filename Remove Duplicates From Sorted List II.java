class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode prev = newHead; newHead.next=head;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(prev.next==cur){
                prev=cur; cur=cur.next;
            }else{
                prev.next=cur.next; cur=cur.next;
            }
        }
        return newHead.next;
    }
}
