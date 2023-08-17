class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length; int n=board[0].length;
        boolean incl[][]=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j]){
                    incl[i][j]=true;
                    if(helper(i,j,1,incl,board,word)) return true;
                    incl[i][j]=false;
                }
            }
        }
        return false;
    }

    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    boolean helper(int row, int col, int idx, boolean incl[][], char board[][], String word){
        if(idx==word.length()) return true;
        for(int k=0; k<4; k++){
            int nI=row+dx[k]; int nJ=col+dy[k];
            if(nI>=0 && nJ>=0 && nI<incl.length && nJ<incl[0].length && !incl[nI][nJ] && word.charAt(idx)==board[nI][nJ]){
                incl[nI][nJ]=true;
                if(helper(nI,nJ,idx+1,incl,board,word)) return true;
                incl[nI][nJ]=false;
            }
        }
        return false;
    }
}
