class GfG
{
    Node flatten(Node root)
    {
	    PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.data-b.data);
	    Node head=null; Node prev=null; q.add(root);
	    while(!q.isEmpty()){
	        Node cur=q.poll();
	        if(head==null){
	            head=prev=cur;
	        }else{
	            prev.bottom=cur; prev=cur;
	        }
	        if(cur.bottom!=null){
	            q.add(cur.bottom);
	        }
	        if(cur.next!=null){
	            q.add(cur.next);
	        }
	        cur.next=cur.bottom=null;
	    }
	    return head;
    }
}
