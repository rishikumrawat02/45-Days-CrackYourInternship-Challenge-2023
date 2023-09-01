class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            list.add(temp);
        }
        return list;
    }
}
