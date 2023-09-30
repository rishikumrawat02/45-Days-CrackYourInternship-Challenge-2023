class Solution {
    int dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        dp=new int[m+1][n+1][len+1];
        int cnt[]=new int[len];

        for(int i=0; i<len; i++){
            int one=0;
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j)=='1') one++;
            }
            cnt[i]=one;
        }

        for(int mat[][]: dp){
            for(int row[]: mat){
                Arrays.fill(row,-1);
            }
        }
        return helper(cnt,strs,0,0,0,m,n,len);
    }

    int helper(int cnt[], String strs[], int i, int curM, int curN, int m, int n, int len){
        if(i>=len) return 0;
        if(dp[curM][curN][i]!=-1) return dp[curM][curN][i];
        int notTake=helper(cnt,strs,i+1,curM,curN,m,n,len);
        int take=0;
        int one=cnt[i]; int zero=strs[i].length()-one;
        if(curM+zero<=m && curN+one<=n){
            take=1+helper(cnt,strs,i+1,curM+zero,curN+one,m,n,len);
        }
        return dp[curM][curN][i]=Math.max(take,notTake);
    }
}
