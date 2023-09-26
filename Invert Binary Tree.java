class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    TreeNode helper(TreeNode root){
        if(root==null) return null;
        helper(root.left);
        helper(root.right);
        TreeNode temp = root.left;
        root.left=root.right; root.right=temp;
        return root;
    }
}
