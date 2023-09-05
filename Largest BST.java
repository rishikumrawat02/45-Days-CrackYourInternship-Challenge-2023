class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    int largestBst(Node root)
    {
        // Write your code here
        if(root==null) return 0;
        int res[]={0};
        helper(root,res);
        return res[0];
    }
    
    int[] helper(Node root, int res[]){
        if(root.left==null && root.right==null){
            res[0]=Math.max(res[0],1);
            return new int[]{root.data,root.data,1};
        }
        if(root.left!=null && root.right!=null){
            int leftArr[] = helper(root.left,res);
            int rightArr[] = helper(root.right,res);
            if(leftArr[2]==-1 || rightArr[2]==-1){
                return new int[]{leftArr[0],rightArr[1],-1};
            }
            if(leftArr[1]>=root.data || rightArr[0]<=root.data) return new int[]{leftArr[0],rightArr[1],-1};
            res[0]=Math.max(res[0],leftArr[2]+rightArr[2]+1);
            return new int[]{leftArr[0],rightArr[1],leftArr[2]+rightArr[2]+1};
        }else if(root.left!=null){
            int leftArr[] = helper(root.left,res);
            if(leftArr[2]==-1) return new int[]{0,0,-1};
            if(leftArr[1]>=root.data) return new int[]{0,0,-1};
            res[0]=Math.max(res[0],leftArr[2]+1);
            return new int[]{leftArr[0],root.data,leftArr[2]+1};
        }
        int rightArr[] = helper(root.right,res);
        if(rightArr[2]==-1) return new int[]{0,0,-1};
        if(rightArr[0]<=root.data) return new int[]{0,0,-1};
        res[0]=Math.max(res[0],rightArr[2]+1);
        return new int[]{root.data,rightArr[1],rightArr[2]+1};
    }
    
}
