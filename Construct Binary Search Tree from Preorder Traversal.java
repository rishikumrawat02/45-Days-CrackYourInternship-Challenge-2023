class Solution {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode helper(int preorder[], int min, int max){
        int n=preorder.length;
        if(i==n) return null;
        if(preorder[i]<=max && preorder[i]>=min){
            TreeNode root = new TreeNode(preorder[i]);
            i++;
            root.left=helper(preorder,min,preorder[i-1]-1);
            root.right=helper(preorder,preorder[i-1]+1,max);
            return root;
        }
        return null;
    }
}
