class Solution {
    TreeNode first=null; TreeNode sec=null; TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        helper(root);
        if(first==null && sec==null) return;
        int temp=first.val;
        first.val=sec.val;
        sec.val=temp;
        return;
    }

    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev!=null){
            if(root.val<prev.val){
                if(first==null){
                    first=prev;
                    sec=root;
                }else sec=root;
            }
        }
        prev=root;
        helper(root.right);
        return;
    }
}
