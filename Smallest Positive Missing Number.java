class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        for(int i=0; i<n; i++){
            if(arr[i]<=0) continue;
            int index=arr[i]-1;
            if(index<n && arr[index]==arr[i]) continue;
            if(index<n){
                int t=arr[index];
                arr[index]=arr[i]; arr[i]=t;
                i--;
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i]!=i+1) return i+1;
        }
        return n+1;
    }
}
