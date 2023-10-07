class Solution
{
    void radixSort(int arr[], int n) 
    { 
        int max=arr[0];
        for(int i=1; i<n; i++) max=Math.max(arr[i],max);
        for(int exp=1; max/exp>0; exp*=10){
            countSort(arr,n,exp);
        }
        return;
    } 
    
    void countSort(int arr[], int n, int exp){
        int tempArr[] = new int[n];
        int count[] = new int[10];
        for(int i=0; i<n; i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i=1; i<10; i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1; i>=0; i--){
            int idx=count[(arr[i]/exp)%10];
            tempArr[idx-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i=0; i<n; i++) arr[i]=tempArr[i];
        return;
    }
}
