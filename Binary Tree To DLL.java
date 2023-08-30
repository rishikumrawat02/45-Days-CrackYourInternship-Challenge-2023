class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node prev=null; Node head=null;
    Node bToDLL(Node root)
    {
        helper(root);
        prev.right=null;
        return head;
    }
    
    void helper(Node cur){
        if(cur==null) return;
        helper(cur.left);
        if(prev==null){
            head=cur; prev=cur;
        }else{
            prev.right=cur;
            cur.left=prev;
            prev=cur;
        }
        helper(cur.right);
        return;
    }
}
