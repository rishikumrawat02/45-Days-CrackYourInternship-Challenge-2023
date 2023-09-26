lass Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null) return res;
        helper(new ArrayList(),root,res);
        return res;
    }

    void helper(ArrayList<Integer> str, TreeNode root, List<String> res){
        if(root.left==null && root.right==null){
            StringBuilder cur = new StringBuilder();
            for(int i=0; i<str.size(); i++){
                cur.append(str.get(i));
                cur.append("->");
            }
            cur.append(root.val);
            res.add(cur.toString());
            return;
        }
        str.add(root.val);
        if(root.left!=null) helper(str,root.left,res);
        if(root.right!=null) helper(str,root.right,res);
        str.remove(str.size()-1);
        return;
    }
}
