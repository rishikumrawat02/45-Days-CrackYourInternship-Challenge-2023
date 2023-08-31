class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }else if(left==right){
            res.add(new TreeNode(left));
            return res;
        }

        for(int i=left; i<=right; i++){
            List<TreeNode> leftList = helper(left,i-1);
            List<TreeNode> rightList= helper(i+1,right);
            for(TreeNode leftNode: leftList){
                for(TreeNode rightNode: rightList){
                    TreeNode root = new TreeNode(i);
                    root.left=leftNode; root.right=rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
