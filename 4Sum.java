class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Long> set = new HashSet<>();
        HashSet<List<Integer>> res = new HashSet<>();
        int n = nums.length; 
        for(int i=0; i<n; i++){
            if(i-1>=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j-1>i && nums[j]==nums[j-1]) continue;
                int k=j+1; int l=n-1;
                while(k<l){
                    long sum=nums[i]*1l+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[j]); temp.add(nums[k]); temp.add(nums[l]);
                        res.add(temp); k++; l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && l+1<n && nums[l]==nums[l+1]) l--;
                    }else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return new ArrayList<>(res);        
    }
}
