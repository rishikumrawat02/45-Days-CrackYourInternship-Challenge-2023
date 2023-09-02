class Solution {
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k,0);
        return res;
    }

    public int helper(TreeNode root, int k, int cnt){
        if(root==null) return 0;
        int leftCnt = helper(root.left,k,cnt);
        if(cnt+leftCnt+1==k){
            res=root.val;
            return k;
        }
        int rightCnt=helper(root.right,k,cnt+leftCnt+1);
        return leftCnt+rightCnt+1;        
    }
}
