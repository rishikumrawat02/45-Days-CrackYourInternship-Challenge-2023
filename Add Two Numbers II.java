class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1); l2=reverse(l2);
        int carry=0;
        ListNode prev=null;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode n = new ListNode((sum%10));
            n.next=prev; prev=n;
            carry=sum/10;
        }
        if(carry!=0){
            ListNode n = new ListNode(carry);
            n.next=prev; prev=n;            
        }
        return prev;
    }

    public ListNode reverse(ListNode node){
        ListNode prev=null; 
        while(node!=null){
            ListNode nxt=node.next;
            node.next=prev;
            prev=node;
            node=nxt;
        }
        return prev;
    }
}
