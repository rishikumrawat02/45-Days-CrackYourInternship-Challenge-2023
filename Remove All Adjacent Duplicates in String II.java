class Solution {
    class Pair{
        char c; int freq;
        Pair(char c, int freq){
            this.c=c; this.freq=freq;
        }
        public String toString(){
            return Character.toString(c).repeat(freq);
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(st.isEmpty() || st.peek().c!=c){
                st.push(new Pair(c,1));
            }else{
                Pair cur = st.pop();
                if(cur.freq==k-1) continue;
                st.push(new Pair(cur.c,cur.freq+1));
            }            
        }
        StringBuilder res = new StringBuilder();
        for (Pair charCount : st) {
            res.append(charCount);
        }
        return res.toString();
    }
}
