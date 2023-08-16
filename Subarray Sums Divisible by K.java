class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int prefixSum[] = new int[n]; 
        HashMap<Integer,Integer> map = new HashMap<>(); 
        map.put(0,1); int res=0;
        for(int i=0; i<n; i++){
            prefixSum[i]=nums[i];
            if(i-1>=0) prefixSum[i]+=prefixSum[i-1];
            int modVal=prefixSum[i]%k;
            if(modVal<0) modVal+=k;
            res+=map.getOrDefault(modVal,0);
            map.put(modVal,map.getOrDefault(modVal,0)+1);
        }
        return res;
    }
}
