class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String str[] = s.split("\\s+");
        for(int i=0; i<str.length/2; i++){
            String temp=str[i];
            str[i]=str[str.length-1-i];
            str[str.length-i-1]=temp;
        }
        String res = "";
        for(int i=0; i<str.length-1; i++){
            res+=str[i]+" ";
        }
        res+=str[str.length-1];
        return res;
    }
}
