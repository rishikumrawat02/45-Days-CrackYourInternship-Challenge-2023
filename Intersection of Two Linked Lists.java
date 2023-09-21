public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1=0; int size2=0;
        ListNode cur=headA;
        while(cur!=null){
            size1++; cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            size2++; cur=cur.next;
        }
        if(size1>size2){
            int diff=size1-size2;
            while(diff>0){
                diff--; headA=headA.next;
            }
        }else if(size2>size1){
            int diff=size2-size1;
            while(diff>0){
                diff--; headB=headB.next;
            }
        }
        while(headA!=headB && headA!=null){
            headA=headA.next; headB=headB.next;
        }
        return headA;
    }
}
