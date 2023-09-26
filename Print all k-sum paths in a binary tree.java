class Solution
{
    int res=0; 
    public int sumK(Node root,int k)
    {
        helper(new ArrayList<>(),root,k);
        return res;
    }
    
    void helper(ArrayList<Integer> path, Node root, int k){
        if(root==null) return;
        path.add(root.data);
        int sum=0;
        for(int i=path.size()-1; i>=0; i--){
            sum+=path.get(i);
            if(sum==k) res++;
        }
        helper(path,root.left,k);
        helper(path,root.right,k);
        path.remove(path.size()-1);
        return;
    }
}
