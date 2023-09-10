class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        helper(res,curRes,cand,target,0);
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> curRes, int[] cand, int target, int idx){
        if(target==0){
            res.add(new ArrayList<>(curRes));
            return;
        }
        if(idx>=cand.length || cand[idx]>target) return;

        for(int i=idx; i<cand.length; i++){
            if(i!=idx && cand[i]==cand[i-1]) continue;
            curRes.add(cand[i]);
            helper(res,curRes,cand,target-cand[i],i+1);
            curRes.remove(curRes.size()-1);
        }
        return;
    }
}
