class Tree
{
    public static float findMedian(Node root)
    {
        // code here.
        int cnt=helper(root);
        // System.out.println(cnt);
        int arr[] = new int[2];
        if(cnt%2==0){
            findNode(root,arr,cnt/2,cnt/2+1,0);
            float res = ((float)(arr[0])+(float)(arr[1]))/2;
            return res;
        }else{
            findNode(root,arr,cnt/2+1,-1,0);
            return (float)arr[0];
        }
    }
    
    static int findNode(Node root, int arr[], int cnt1, int cnt2, int cnt){
        if(root==null) return 0;
        int left=findNode(root.left,arr,cnt1,cnt2,cnt);
        if(cnt+left+1==cnt1){
            arr[0]=root.data;
        }else if(cnt+left+1==cnt2){
            arr[1]=root.data;
        }
        int right=findNode(root.right,arr,cnt1,cnt2,left+cnt+1);
        return left+right+1;
    }
    
    static int helper(Node root){
        if(root==null) return 0;
        return helper(root.left)+helper(root.right)+1;
    }
}
