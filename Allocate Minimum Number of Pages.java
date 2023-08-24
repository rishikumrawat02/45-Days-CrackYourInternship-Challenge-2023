class Solution 
{
    //Function to find minimum number of pages.
    public int findPages(int[]arr,int N,int M)
    {
        //Your code here
        int low=arr[0]; int high=0;
        for(int val: arr){
            high+=val; low=Math.max(low,val);
        }
        if(M>N) return -1;
        int res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(mid,arr,N,M)){
                res=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return res;
    }
    
    boolean isPossible(int maxBook, int arr[], int n, int m){
        int page=0; int s=1;
        for(int i=0; i<n; i++){
            if(arr[i]>maxBook) return false;
            if(arr[i]+page>maxBook){
                s++;
                page=arr[i];
            }else page+=arr[i];
        }
        if(s>m) return false;
        return true;
    }
};
