class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long res=Long.MAX_VALUE;
        for(int i=0; i<=n-m; i++){
            long diff=a.get(i+m-1)*1l-a.get(i);
            res=Math.min(res,diff);
        }
        return res;
    }
}
