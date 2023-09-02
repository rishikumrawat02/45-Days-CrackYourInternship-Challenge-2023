class Solution {
    int res=0;
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        helper(root,target);
        return res;
    }

    HashMap<Long,Integer> helper(TreeNode root, int target){
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(root.val*1l,1);
        if(root.val==target) res++;

        if(root.left==null && root.right==null){
            return map;
        }
    
        HashMap<Long,Integer> left=(root.left==null)?new HashMap<>():helper(root.left,target);
        for(Long key: left.keySet()){
            if(key+root.val==target){
                res+=left.get(key);
            }
            map.put(key+root.val,map.getOrDefault(key+root.val,0)+left.get(key));
        }

        HashMap<Long,Integer> right=(root.right==null)?new HashMap<>():helper(root.right,target);
        for(Long key: right.keySet()){
            if(key+root.val==target){
                res+=right.get(key);
            }
            map.put(key+root.val,map.getOrDefault(key+root.val,0)+right.get(key));
        }

        return map;
        
    }
}
