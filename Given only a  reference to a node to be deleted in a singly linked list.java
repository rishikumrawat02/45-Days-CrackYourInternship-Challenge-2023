class Solution {
    public void deleteNode(ListNode node) {
        if(node==null) return;
        if(node.next==null){
            node=null; return;
        }
        ListNode prevPrev=null; ListNode prev=node; ListNode cur=node.next;
        while(cur!=null){
            prev.val=cur.val; prevPrev=prev; prev=cur; cur=cur.next;
        }
        prevPrev.next=null;
        return;
    }
}
