class Solution {
    public int majorityElement(int[] nums) {
        int vote=1; int cand=nums[0]; int n=nums.length;
        for(int i=1; i<n; i++){
            if(nums[i]==cand) vote++;
            else vote--;
            if(vote==0){
                cand=nums[i]; 
                vote=1;
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==cand) cnt++;
        }
        if(cnt>n/2) return cand;
        return -1;
    }
}
