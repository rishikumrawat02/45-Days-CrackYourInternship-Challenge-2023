class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,new StringBuilder(),n,0);
        return res;        
    }

    void helper(List<String> res, StringBuilder str, int opn, int cls){
        if(opn==0 && cls==0){
            res.add(new String(str));
            return;
        }
        if(opn!=0){
            str.append('(');
            helper(res,str,opn-1,cls+1);
            str.deleteCharAt(str.length()-1);
        }
        if(cls!=0){
            str.append(')');
            helper(res,str,opn,cls-1);
            str.deleteCharAt(str.length()-1);
        }
        return;
    }
}
