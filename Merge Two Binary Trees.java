lass Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return helper(root1,root2);
    }

    TreeNode helper(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return null;
        else if(root1==null) return root2;
        else if(root2==null) return root1;
        TreeNode newNode = new TreeNode(root1.val+root2.val);
        newNode.left=helper(root1.left,root2.left);
        newNode.right=helper(root1.right,root2.right);
        return newNode;
    }
}
