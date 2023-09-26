class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;
    }

    void helper(TreeNode root, int low, int high){
        if(root==null) return;
        helper(root.left,low,high);
        helper(root.right,low,high);
        if(root.val>=low && root.val<=high) sum+=root.val;
        return;
    }
}
