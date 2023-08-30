class Solution {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root){
        if(root==null) return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        res=Math.max(res,root.val);
        res=Math.max(res,root.val+left);
        res=Math.max(res,root.val+right);
        res=Math.max(res,left+right+root.val);
        return Math.max(root.val,Math.max(left,right)+root.val);
    }
}
