class NumArray {

    int tree[]; int n;
    public NumArray(int[] nums) {
        this.n=nums.length;
        tree=new int[4*n];
        buildTree(0,n-1,0,nums);
    }

    public void buildTree(int l, int r, int idx, int nums[]){
        if(l==r){
            tree[idx]=nums[l];
            return;
        }
        int mid=(l+r)/2;
        buildTree(l,mid,2*idx+1,nums);
        buildTree(mid+1,r,2*idx+2,nums);
        tree[idx]=tree[2*idx+1]+tree[2*idx+2];
        return;
    }

    int getAns(int qS, int qE, int l, int r, int idx){
        if(qS>qE) return 0;
        if(l>=qS && r<=qE) return tree[idx];
        int mid=(l+r)/2;
        int leftAns=getAns(qS,Math.min(qE,mid),l,mid,2*idx+1);
        int righAns=getAns(Math.max(qS,mid+1),qE,mid+1,r,2*idx+2);
        return leftAns+righAns;
    }
    
    public void update(int index, int val) {
        update(0,n-1,index,val,0);
    }

    void update(int l, int r, int pos, int val, int idx){
        if(l==r){
            tree[idx]=val;
            return;
        }
        int mid=(l+r)/2;
        if(pos<=mid) update(l,mid,pos,val,2*idx+1);
        else update(mid+1,r,pos,val,2*idx+2);
        tree[idx]=tree[2*idx+1]+tree[2*idx+2];
        return;
    }
    
    public int sumRange(int left, int right) {
        return getAns(left,right,0,n-1,0);
    }
}
