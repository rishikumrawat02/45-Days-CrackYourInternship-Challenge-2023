class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0);
    }

    int helper(String s, int idx){
        if(idx==s.length()) return 1;
        if(dp[idx]!=-1) return dp[idx];
        if(s.charAt(idx)=='0') return dp[idx]=0;
        int res=res=helper(s,idx+1);
        if(idx<s.length()-1){
            if(s.charAt(idx)=='1') res+=helper(s,idx+2);
            else if(s.charAt(idx)=='2' && s.charAt(idx+1)-'0'<7) res+=helper(s,idx+2);
        }
        return dp[idx]=res;
    }
}
