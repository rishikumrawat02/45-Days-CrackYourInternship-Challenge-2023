class Solution
{
    //Function to find the largest number after k swaps.
    public String findMaximumNum(String str, int k){
        String res[] = {""};
        char arr[] = str.toCharArray();
        helper(arr,0,k,res);
        return res[0];
    }
    
    void helper(char arr[], int idx, int k, String res[]){
        if(idx==arr.length || k==0){
            if(isGreater(arr,res[0])){
                res[0]=new String(arr);
            }
            return;
        }
        helper(arr,idx+1,k,res);
        for(int i=idx+1; i<arr.length; i++){
            char temp=arr[idx];
            arr[idx]=arr[i];
            arr[i]=temp;
            helper(arr,idx+1,k-1,res);
            arr[i]=arr[idx];
            arr[idx]=temp;
        }
        return;
    }
    
    boolean isGreater(char arr[], String num){
        if(arr.length>num.length()) return true;
        if(arr.length<num.length()) return false;
        
        int n=arr.length;
        int i=0;
        while(i<n && (arr[i]-'0'==num.charAt(i)-'0')){
            i++;
        }
        if(i==n) return true;
        if(arr[i]-'0'>num.charAt(i)-'0') return true;
        return false;
    }
}
