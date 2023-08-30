class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }

    TreeNode helper(TreeNode root, TreeNode nod1, TreeNode nod2){
        if(root==null || root==nod1 || root==nod2) return root;
       
        TreeNode left=helper(root.left,nod1,nod2);
        TreeNode right=helper(root.right,nod1,nod2);

        if(left==null) return right;
        if(right==null) return left;
        else return root;
    }
}
