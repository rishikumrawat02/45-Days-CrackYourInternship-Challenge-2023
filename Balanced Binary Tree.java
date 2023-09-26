class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root)==-1?false:true;
    }

    int helper(TreeNode root){
        if(root==null) return 0;
        int left=helper(root.left);
        int rigt=helper(root.right);
        if(left==-1 || rigt==-1) return -1;
        if(Math.abs((left-rigt))>1) return -1;
        return Math.max(left,rigt)+1;
    }
}
