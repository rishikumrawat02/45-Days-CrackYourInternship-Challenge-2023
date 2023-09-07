class Solution {
    int dp[][][]; int max=(int)1e2;
    public int removeBoxes(int[] boxes) {
        dp=new int[max][max][max];
        for(int row[][]: dp){
            for(int col[]: row){
                Arrays.fill(col,-1);
            }
        }
        int n=boxes.length;
        return helper(0,n-1,0,boxes);
    }

    public int helper(int i, int j, int streak, int []boxes){
        if(i>j) return 0;
        else if(i==j){
            return (streak+1)*(streak+1);
        }else if(dp[i][j][streak]!=-1) return dp[i][j][streak];
        int maxPoint=(streak+1)*(streak+1)+helper(i+1,j,0,boxes);
        for(int k=i+1; k<=j; k++){
            if(boxes[k]==boxes[i]){
                maxPoint=Math.max(maxPoint,helper(i+1,k-1,0,boxes)+helper(k,j,streak+1,boxes));
            }
        }
        return dp[i][j][streak]=maxPoint;
    }
}
