class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int slen=s.length(); int plen=p.length();
        int org[] = new int[26]; int diff=0;
        for(int i=0; i<plen; i++){
            org[p.charAt(i)-'a']++;
            if(org[p.charAt(i)-'a']==1) diff++;
        }
        int arr[] = new int[26]; int left=0; int cnt=0;
        String res = ""; int resLen=Integer.MAX_VALUE;
        for(int i=0; i<slen; i++){
            char c=s.charAt(i);
            if(org[c-'a']!=0){
                arr[c-'a']++;
                if(arr[c-'a']==org[c-'a']) cnt++;
            }
    
            while(cnt==diff){
                if(res.equals("") || res.length()>(i-left+1)){
                    res=s.substring(left,i+1);
                }
                c=s.charAt(left);
                if(org[c-'a']!=0){
                    arr[c-'a']--;
                    if(arr[c-'a']<org[c-'a']) cnt--;
                }
                left++;
            }
        }
        if(res.length()==0) return "-1";
        return res;
    }
}
