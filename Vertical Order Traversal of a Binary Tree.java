class Solution {
    Map<Integer,ArrayList<int[]>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        helper(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(Integer key: map.keySet()){
            ArrayList<int[]> l = map.get(key);
            List<Integer> temp = new ArrayList<>();
            Collections.sort(l,new Comparator<int[]>(){
                public int compare(int a[], int b[]){
                    if(a[0]==b[0]){
                        return Integer.compare(a[1],b[1]);
                    }
                    return Integer.compare(a[0],b[0]);
                }
            });
            for(int i=0; i<l.size(); i++){
                temp.add(l.get(i)[1]);
            }
            res.add(temp);
        }
        return res;
    }

    void helper(TreeNode root, int row, int col){
        if(root==null) return;
        map.putIfAbsent(col,new ArrayList<>());
        map.get(col).add(new int[]{row,root.val});
        helper(root.left,row+1,col-1);
        helper(root.right,row+1,col+1);
        return;
    }
}
