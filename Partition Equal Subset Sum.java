class Solution{
    int equalPartition(int N, int arr[])
    {
        // code here
        Arrays.sort(arr);
        int sum=0; 
        for(int val: arr) sum+=val;
        if(sum%2!=0) return 0;
        int target=sum/2;
        int vis[][] = new int[sum+1][N];
        return helper(vis,0,arr,target)?1:0;
    }
    
    boolean helper(int vis[][], int idx, int arr[], int target){
        if(target==0) return true;
        if(idx==arr.length || arr[idx]>target) return false;
        if(vis[target][idx]==1) return false;
        vis[target][idx]=1;
        if(helper(vis,idx+1,arr,target)) return true;
        if(helper(vis,idx+1,arr,target-arr[idx])) return true;
        return false;
    }
}
