class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        helper(1,n,k,res,curRes);
        return res;
    }

    void helper(int s, int n, int k, List<List<Integer>> res, List<Integer> curRes){
        if(k==0){
            res.add(new ArrayList<>(curRes));
            return;
        }
        if(n-s+1<k) return;
        for(int i=s; i<=n; i++){
            curRes.add(i);
            helper(i+1,n,k-1,res,curRes);
            curRes.remove(curRes.size()-1);
        }
        return;
    }
}
