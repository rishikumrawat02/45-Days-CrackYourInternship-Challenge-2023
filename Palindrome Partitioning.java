class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(0,temp,s,answer);
        return answer;
    }

    void helper(int idx, List<String> temp, String s, List<List<String>> answer){
        if(idx==s.length()){
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(i+1,temp,s,answer);
                temp.remove(temp.size()-1);
            }
        }

        return;
    }

    boolean isPalindrome(String s){
        int i=0; int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
