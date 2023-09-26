class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            st.push(cur);
            cur=cur.left;
        }
    }
    
    public int next() {
        TreeNode cur = st.pop();
        int res=cur.val; cur=cur.right;
        while(cur!=null){
            st.push(cur);
            cur=cur.left;
        }
        return res;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}
