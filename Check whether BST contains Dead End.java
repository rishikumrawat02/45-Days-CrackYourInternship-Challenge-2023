class GFG
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return helper(root,1,Integer.MAX_VALUE);
    }
    
    static boolean helper(Node root, int low, int high){
        if(root==null) return false;
        if(root.data==high && root.data==low) return true;
        return helper(root.left,low,root.data-1) || helper(root.right,root.data+1,high);
    }
}
