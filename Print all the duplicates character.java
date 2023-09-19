import java.util.*; 
class Solution {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        method1(str);
        method2(str);
    }
    
    public static void method1(String str){
        int freq[] = new int[26];
        for(int i=0; i<str.length(); i++){
            freq[str.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq[i]==0) continue;
            System.out.println((char)(i+'a')+" "+freq[i]);
        }
    }
    
    public static void method2(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);
        int cnt=1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
            }else{
                System.out.println(s.charAt(i-1)+" "+cnt);
                cnt=1;
            }
        }
        System.out.println(s.charAt(s.length()-1)+" "+cnt);
    }
}
