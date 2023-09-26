class Solution {
    TreeNode prev=null; int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }

    void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev!=null){
            minDiff=Math.min(minDiff,root.val-prev.val);
        }
        prev=root;
        helper(root.right);
        return;
    }
}
