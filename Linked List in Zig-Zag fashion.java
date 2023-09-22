class Solution{
	public static Node zigZag(Node head){
        Node cur=head; boolean flag=true;
        while(cur!=null && cur.next!=null){
            if(flag){
                if(cur.data<cur.next.data) ;
                else{
                    int temp=cur.data; cur.data=cur.next.data; cur.next.data=temp;
                }
            }else{
                if(cur.data>cur.next.data) ;
                else{
                    int temp=cur.data; cur.data=cur.next.data; cur.next.data=temp;
                }
            }
            cur=cur.next;
            flag=!flag;
        }
        return head;
    }
}
