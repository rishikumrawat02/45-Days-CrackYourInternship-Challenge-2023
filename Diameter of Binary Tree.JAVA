class Solution {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left); int r=helper(root.right);
        res=Math.max(res,l+r);
        return Math.max(l,r)+1;
    }
}
