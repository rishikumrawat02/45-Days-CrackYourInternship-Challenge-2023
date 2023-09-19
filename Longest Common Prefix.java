class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int minLen=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minLen=Math.min(minLen,strs[i].length());
        }
        int j=0;
        for(;j<minLen; j++){
            boolean res=true;
            for(int i=1; i<n; i++){
                if(strs[i].charAt(j)!=strs[0].charAt(j)){
                    res=false; break;
                }
            }
            if(!res){
                break;
            }
        }
        return strs[0].substring(0,j);
    }
}
