class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            if(flag){
                Collections.reverse(temp);
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }
}
