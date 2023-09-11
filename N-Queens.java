class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new LinkedList<>();
        int grid[][] = new int[n][n];
        helper(res,list,grid,0,n);
        return res;
    }

    void helper(List<List<String>> res, List<String> list, int grid[][], int row, int n){
        if(row==n){
            res.add(new LinkedList<>(list));
            return;
        }

        for(int col=0; col<n; col++){
            if(isPossible(row,col,n,grid)){
                String str = getString(col,n);
                list.add(str); grid[row][col]=1;
                helper(res,list,grid,row+1,n);
                list.remove(list.size()-1); grid[row][col]=0;
            }
        }
        return;
    }

    boolean isPossible(int row, int col, int n, int grid[][]){
        int i=row-1; int j=col-1;
        while(i>=0 && j>=0){
            if(grid[i][j]==1) return false;
            i--; j--;
        }
        i=row-1; j=col+1;
        while(i>=0 && j<n){
            if(grid[i][j]==1) return false;
            i--; j++;
        }
        for(i=row-1; i>=0; i--){
            if(grid[i][col]==1) return false;
        }
        return true;
    }

    String getString(int i, int n){
        StringBuilder str = new StringBuilder();
        for(int k=0; k<n; k++){
            if(k==i){
                str.append("Q");
            }else str.append(".");
        }
        return str.toString();
    }
}
