class Solution {
    class Pair{
        int pos; TreeNode node;
        Pair(int pos, TreeNode node){
            this.pos=pos; this.node=node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1,root)); int res=1;
        while(!q.isEmpty()){
            int size=q.size();
            int leftPos=-1; int rightPos=-1;
            while(size-->0){
                Pair cur = q.poll();
                if(leftPos==-1){
                    leftPos=cur.pos; rightPos=cur.pos;
                }else{
                    rightPos=cur.pos;
                }
                if(cur.node.left!=null) q.add(new Pair(cur.pos*2,cur.node.left));
                if(cur.node.right!=null) q.add(new Pair(cur.pos*2+1,cur.node.right));
            }
            res=Math.max(res,rightPos-leftPos+1);
        }
        return res;
    }
}
