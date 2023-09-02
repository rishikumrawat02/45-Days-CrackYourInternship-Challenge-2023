class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        return helper(root,l,h);
    }
    
    int helper(Node root, int l, int h){
        if(root==null) return 0;
        int res=0;
        if(root.data>=l && root.data<=h){
            res++;
            res+=helper(root.left,l,h);
            res+=helper(root.right,l,h);
        }else if(root.data<l){
            res+=helper(root.right,l,h);
        }else{
            res+=helper(root.left,l,h);
        }
        return res;
    }
}
