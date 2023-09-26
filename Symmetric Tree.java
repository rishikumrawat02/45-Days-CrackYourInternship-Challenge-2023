class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }

    boolean helper(TreeNode root, TreeNode toor){
        if(root==null && toor==null) return true;
        else if(root==null || toor==null) return false;
        if(root.val!=toor.val) return false;
        return helper(root.left,toor.right) && helper(root.right,toor.left);
    }
}
