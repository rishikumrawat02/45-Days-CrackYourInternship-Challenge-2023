class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        int pos=0; ListNode lPrev=null; ListNode lNode=null; ListNode rNode=null;
        ListNode prev=null; ListNode cur=head;
        while(cur!=null){
            pos++;
            if(pos==left){
                lPrev=prev;
                lNode=cur;
            }
            if(pos==right){
                rNode=cur;
            }
            prev=cur;
            cur=cur.next;
        }
        ListNode rNxt=rNode.next;
        reverse(lNode,rNode);
        if(lNode==head){
            lNode.next=rNxt;
            return rNode;
        }
        
        lPrev.next=rNode;
        lNode.next=rNxt;        
        return head;
    }

    ListNode reverse(ListNode left, ListNode right){
        ListNode prev=null;
        ListNode cur=left;
        while(cur!=null && cur!=right){
            ListNode nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        cur.next=prev;
        return cur;
    }
}
