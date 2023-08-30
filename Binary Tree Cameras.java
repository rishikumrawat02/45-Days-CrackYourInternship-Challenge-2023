class Solution {
    int cam;
    Set<TreeNode> set;
    public int minCameraCover(TreeNode root) {
        cam=0;
        set=new HashSet<>();
        set.add(null);
        helper(root,null);
        return cam;
    }

    void helper(TreeNode root, TreeNode par){
        if(root==null) return;
        helper(root.left,root);
        helper(root.right,root);
        if(par==null && !set.contains(root) || !set.contains(root.left) || !set.contains(root.right)){
            cam++; set.add(root); set.add(root.left); set.add(root.right); set.add(par);
        }
        return;
    }
}
