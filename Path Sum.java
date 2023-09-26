class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        if(root==null) return false;
        return helper(root,0,target);
    }
    boolean helper(TreeNode root, int curSum, int target){
        if(root.left==null && root.right==null){
            if(curSum==target-root.val) return true;
            return false;
        }
        if(root.left!=null && helper(root.left,curSum+root.val,target)) return true;
        if(root.right!=null && helper(root.right,curSum+root.val,target)) return true;
        return false;
    }
}
