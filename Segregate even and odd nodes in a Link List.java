
class Solution{
    Node divide(int N, Node head){
        Node evenHead=null; Node evn=null; Node oddHead=null; Node odd=null;
        while(head!=null){
            int data=head.data;
            if(data%2==0){
                if(evenHead==null){
                    evenHead=evn=head;
                }else{
                    evn.next=head; evn=head;
                }
            }else{
                if(oddHead==null){
                    oddHead=odd=head;
                }else{
                    odd.next=head; odd=head;
                }
            }
            head=head.next;
        }
        if(evenHead==null) return oddHead;
        evn.next=oddHead;
        if(oddHead!=null) odd.next=null;
        return evenHead;
    }
}
