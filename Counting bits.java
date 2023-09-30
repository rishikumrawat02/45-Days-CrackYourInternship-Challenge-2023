class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i]=(i%2==0)?arr[i/2]:arr[i-1]+1;
        }        
        return arr;
    }
}
