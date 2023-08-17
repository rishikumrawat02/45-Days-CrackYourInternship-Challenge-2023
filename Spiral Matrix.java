class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m=matrix.length; int n=matrix[0].length;
        int left=0; int right=n-1; int top=0; int bot=m-1;
        while(left<=right && top<=bot){
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bot; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bot){
                for(int i=right; i>=left; i--){
                    res.add(matrix[bot][i]);
                }
                bot--;
            }
            if(left<=right){
                for(int i=bot; i>=top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
