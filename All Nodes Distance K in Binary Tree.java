/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        helper(root,target,st);
        TreeNode prev=null;
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            findNode(prev,cur,k,list);
            k--; prev=cur;
        }
        return list;
    }

    boolean helper(TreeNode root, TreeNode target, Stack<TreeNode> st){
        if(root==null) return false;
        st.push(root);
        if(root==target) return true;
        if(helper(root.left,target,st)) return true;
        if(helper(root.right,target,st)) return true;
        st.pop();
        return false;
    }

    void findNode(TreeNode prev, TreeNode root, int k, List<Integer> res){
        if(root==null) return;
        if(k==0){
            res.add(root.val);
            return;
        }
        if(root.left!=prev) findNode(root,root.left,k-1,res);
        if(root.right!=prev) findNode(root,root.right,k-1,res);
        return;
    }
}
