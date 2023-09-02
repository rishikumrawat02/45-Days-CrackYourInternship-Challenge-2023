lass Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        helper(root);
        return root;
    }

    void helper(Node root){
        if(root.left==null) return;
        setNext(root,root.left);
        helper(root.left);
        return;
    }

    void setNext(Node root, Node left){
        while(root!=null){
            left.next=root.right;
            left=left.next; root=root.next;
            if(root!=null){
                left.next=root.left;
                left=left.next;
            }
        }
        return;
    }
}
