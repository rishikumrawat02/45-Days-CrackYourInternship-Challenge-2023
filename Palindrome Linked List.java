class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode prev=null; ListNode slow=head; ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow; slow=slow.next; fast=fast.next.next;
        }
        if(fast!=null){
            prev=slow; slow=slow.next;
        }
        while(slow!=null){
            ListNode next=slow.next; slow.next=prev;
            prev=slow; slow=next;
        }
        slow=head; fast=prev;

        while(slow!=fast){
            if(slow.val!=fast.val) return false;
            if(fast.next==slow) break;
            slow=slow.next; fast=fast.next;
        }
        return true;
    }
}
