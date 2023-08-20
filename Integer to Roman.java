class Solution {
    public String intToRoman(int num) {
       int arr[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
       String str[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       StringBuilder res = new StringBuilder();
       for(int i=0; i<arr.length; i++){
           int modVal=num%arr[i];
           int time=num/arr[i];
           num=modVal;
           for(int j=0; j<time; j++){
               res.append(str[i]);
           }
       }
       return res.toString();
    }
}
