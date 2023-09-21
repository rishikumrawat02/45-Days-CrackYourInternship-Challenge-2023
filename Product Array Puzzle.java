class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        long res[] = new long[n];
        long prod=1l;
        for(int i=0; i<n; i++){
            res[i]=prod; prod*=nums[i];
        }
        prod=1l;
        for(int i=n-1; i>=0; i--){
            res[i]*=prod; prod*=nums[i];
        }
        return res;
	} 
} 
