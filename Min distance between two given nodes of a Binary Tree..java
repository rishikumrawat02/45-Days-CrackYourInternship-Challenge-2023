class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = findLca(root,a,b);
        int dist[] = new int[3];
        helper(a,b,lca.data,root,dist,0);
        // System.out.println(dist[0]+" "+dist[1]+" "+dist[2]+" "+lca.data);
        return dist[0]+dist[1]-2*dist[2];
    }
    
    void helper(int a, int b, int c, Node root, int dist[], int curDist){
        if(root==null) return;
        if(root.data==a){
            dist[0]=curDist+1;
        }
        if(root.data==b){
            dist[1]=curDist+1;
        }
        if(root.data==c){
            dist[2]=curDist+1;
        }
        helper(a,b,c,root.left,dist,curDist+1);
        helper(a,b,c,root.right,dist,curDist+1);
        return;
    }
    
    Node findLca(Node root, int a, int b){
        if(root==null) return null;
        Node left=findLca(root.left,a,b);
        Node right=findLca(root.right,a,b);
        if((root.data==a || root.data==b) || (left!=null && right!=null)) return root;
        if(left==null && right==null) return null;
        if(left!=null) return left;
        return right;
    }
}
