class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0,nums.length-1,nums);
    }

    TreeNode helper(int low, int high, int nums[]){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(low,mid-1,nums);
        root.right=helper(mid+1,high,nums);
        return root;
    }
}
