class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int sum=nums[i]+nums[j];
                if(set.contains(-sum)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]); 
                    list.add(-sum);
                    Collections.sort(list);
                    res.add(list);
                }
            }
            set.add(nums[i]);
        }        
        System.out.println(res.size());
        return new ArrayList<>(res);
    }
}
