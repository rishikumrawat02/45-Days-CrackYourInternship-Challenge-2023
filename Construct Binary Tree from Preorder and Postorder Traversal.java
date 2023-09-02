class Solution {
    int index; HashMap<Integer,Integer> map;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        index=0;
        map = new HashMap<>();
        for(int i=0; i<post.length; i++){
            map.put(post[i],i);
        }
        return helper(pre,0,post.length-1);
    }

    TreeNode helper(int pre[], int l, int r){
        if(l>r) return null;
        TreeNode root = new TreeNode(pre[index++]);
        if(l==r) return root;
        int idx=map.get(pre[index]);
        root.left=helper(pre,l,idx);
        root.right=helper(pre,idx+1,r-1);
        return root;
    }
}
