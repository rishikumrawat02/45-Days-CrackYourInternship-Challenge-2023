class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        StringBuilder aStr= new StringBuilder(a); aStr=aStr.reverse();
        StringBuilder bStr= new StringBuilder(b); bStr=bStr.reverse();
        int n=a.length(); int m=b.length();
        int cary=0;
        for(int i=0; i<Math.max(n,m); i++){
            int sum=cary;
            sum+=(i<n && aStr.charAt(i)=='1')?1:0; sum+=(i<m && bStr.charAt(i)=='1')?1:0;
            if(sum==0){
                str.append('0');
            }else if(sum==1){
                cary=0; str.append('1');
            }else if(sum==2){
                cary=1; str.append('0');
            }else{
                cary=1; str.append('1');
            }
        }
        if(cary!=0) str.append('1');
        return str.reverse().toString();        
    }
}
