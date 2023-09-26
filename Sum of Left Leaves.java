class Solution {
    int res=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        helper(root,1);
        return res;
    }

    void helper(TreeNode root, int isL){
        if(root.left==null && root.right==null){
            if(isL==0) res+=root.val;
            return;
        }
        if(root.left!=null){
            helper(root.left,0);
        }
        if(root.right!=null){
            helper(root.right,1);
        }
        return;
    }
}
