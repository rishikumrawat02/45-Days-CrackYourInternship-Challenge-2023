class Solution {
    public boolean isNumber(String s) {
        int n=s.length();
        boolean digitFound=false;
        boolean eFound=false;
        boolean decFound=false;
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(c=='+' || c=='-'){
                if(i==0 || (s.charAt(i-1)=='e' || s.charAt(i-1)=='E')){
                    digitFound=false;
                }else return false;
            }else if(c=='e' || c=='E'){
                if(eFound || !digitFound ) return false;
                eFound=true;
                digitFound=false;
            }else if(c=='.'){
                if(decFound || eFound) return false;
                decFound=true;
            }else if(!Character.isDigit(c)){
                return false;
            }else{
                digitFound=true;
            }
        }
        return digitFound;
    }
}
