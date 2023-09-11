class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> list = new HashSet<>();
        List<Integer> curList = new ArrayList<>();
        int n=nums.length;  int mask=(1<<n)-1;
        helper(list,curList,mask,nums);
        return new ArrayList<>(list);        
    }

    void helper(HashSet<List<Integer>> list, List<Integer> curList, int mask, int nums[]){
        int n=nums.length;
        if(mask==0){
            list.add(new ArrayList<>(curList));
            return;
        }
        for(int i=0; i<n; i++){
            if((mask&1<<i)!=0){
                curList.add(nums[i]);
                helper(list,curList,mask^1<<i,nums);
                curList.remove(curList.size()-1);              
            }
        }

        return;
    }
}
