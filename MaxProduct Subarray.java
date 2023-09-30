class Solution {
    public int maxProduct(int[] arr) {
        int n=arr.length;
        long res = Integer.MIN_VALUE;
        long prevMax=1;
        long prevMin=1;
        if(n==1) return arr[0];
        for(int i=0; i<n; i++){
           if(arr[i]>0){
               prevMax*=arr[i];
               prevMin=Math.min(arr[i]*prevMin,1);
               res=Math.max(res,prevMax);
           }else if(arr[i]<0){
               long temp = prevMin;
               prevMin=prevMax*arr[i];
               prevMax=Math.max(temp*arr[i],1);
               if(temp*arr[i]!=1 && prevMax==1) continue;
               res = Math.max(prevMax,res);
           }else{
              
               prevMax=1;
               prevMin=1;
           }
        }
        
        if(res==Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}
