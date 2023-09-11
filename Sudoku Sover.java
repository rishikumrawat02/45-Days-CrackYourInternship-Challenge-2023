class Solution {
    public void solveSudoku(char[][] board) {
        helper(0,0,board);
    }

    boolean helper(int row, int col, char[][]board){
        if(col==9){
            row=row+1; col=0;
        }
        if(row==9) return true;
        if(board[row][col]!='.') return helper(row,col+1,board);

        for(int val=1; val<=9; val++){
            if(isPossible(row,col,board,val)){
                board[row][col]=(char)('0'+val);
                boolean succ = helper(row,col+1,board);
                if(succ) return true;
            }
        }

        board[row][col]='.';
        return false;
    }

    boolean isPossible(int row, int col, char[][]board, int val){
        for(int i=0; i<9; i++){
            if(board[row][i]==(char)('0'+val)) return false;
        }
        for(int i=0; i<9; i++){
            if(board[i][col]==(char)('0'+val)) return false;
        }
        int rowStart=row/3*3;
        int colStart=col/3*3;
        for(int i=rowStart; i<rowStart+3; i++){
            for(int j=colStart; j<colStart+3; j++){
                if(board[i][j]==(char)('0'+val)) return false;
            }            
        }
        return true;
    }
}
