class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> curRes = new ArrayList<>();
        helper(set,curRes,0,nums);
        return new ArrayList<>(set);
    }
    void helper(HashSet<List<Integer>> res, List<Integer> curRes, int idx, int nums[]){
        int n=nums.length;
        if(idx==n){
            res.add(new ArrayList<>(curRes));
            return;
        }
        helper(res,curRes,idx+1,nums);
        curRes.add(nums[idx]);
        helper(res,curRes,idx+1,nums);
        curRes.remove(curRes.size()-1);
        return;
    }
}
