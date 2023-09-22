class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        while(n>0){
            n--; fast=fast.next;
        }
        ListNode prev=null;
        ListNode slow=head;
        while(fast!=null){
            prev=slow; slow=slow.next; fast=fast.next;
        }
        if(prev==null) return head.next;
        prev.next=slow.next;        
        return head;
    }
}
