class Solution {
    public String minWindow(String s, String t) {
        int tFreq[] = new int[257];
        int sFreq[] = new int[257];
        int m=t.length(); int n=s.length();
        for(int i=0; i<m; i++){
            tFreq[t.charAt(i)]++;
        }
        int left=0; int res=n+1; int b=-1; int e=-1;
        for(int i=0; i<n; i++){
            sFreq[s.charAt(i)]++;
            if(isPossible(sFreq,tFreq)){
                int len=i-left+1;
                if(len<res){
                    res=len; b=left; e=i+1;
                }
            }
            while(isPossible(sFreq,tFreq)){
                int len=i-left+1;
                if(len<res){
                    res=len; b=left; e=i+1;
                }
                sFreq[s.charAt(left++)]--;
            }
        }
        if(b==-1) return "";
        return s.substring(b,e);
    }

    boolean isPossible(int sArr[], int tArr[]){
        for(int i=0; i<=256; i++){
            if(sArr[i]<tArr[i]) return false;
        }
        return true;
    }
}
