class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int freq[] = new int[26];
        int maxFreq=0; int idx=-1;
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
            if(freq[s.charAt(i)-'a']>maxFreq){
                maxFreq=freq[s.charAt(i)-'a']; idx=s.charAt(i)-'a';
            }
        }

        if(maxFreq>((n+1)/2)) return "";

        char res[] = new char[n];
        int index=0;
        while(freq[idx]>0){
            res[index]=(char)(idx+'a');
            freq[idx]--; index+=2;
        }

        for(int i=0; i<26; i++){
            if(freq[i]==0) continue;
            while(freq[i]!=0){
                if(index>=n) index=1;
                res[index]=(char)(i+'a');
                index+=2; freq[i]--;
            }
        }

        return new String(res);
    }
}
