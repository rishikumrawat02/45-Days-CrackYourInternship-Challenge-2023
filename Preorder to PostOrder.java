public static Node post_order(int pre[], int size) 
{
    return helper(0,size-1,pre);
} 

static Node helper(int left, int right, int pre[]){
    if(right<left) return null;
    Node root = new Node(pre[left]);
    int nxtGreater=right+1;
    for(int i=left+1; i<=right; i++){
        if(pre[i]>pre[left]){
            nxtGreater=i; break;
        }
    }
    root.left=helper(left+1,nxtGreater-1,pre);
    root.right=helper(nxtGreater,right,pre);
    return root;
}
