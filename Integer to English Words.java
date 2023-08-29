class Solution {
    public String numberToWords(int num) {
        int i=0; StringBuilder str = new StringBuilder();
        if(num==0) return "Zero";
        while(num>0){
            int digit=num%1000;
            num=num/1000;
            String res = convert(digit);
            res=res.trim();
            if(i==1){
                if(res.length()!=0) str.insert(0," Thousand ");
                str.insert(0,res);
            }else if(i==2){
                if(res.length()!=0) str.insert(0," Million ");
                str.insert(0,res);
            }else if(i==3){
                if(res.length()!=0) str.insert(0," Billion ");
                str.insert(0,res);
            }else{
                str.insert(0,res);
            }
            i++;
        }
        return str.toString().trim();
    }

    String convert(int num){
        String arr[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String arr1[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String arr2[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num<10){
            return arr[num];
        }else if(num<20){
            return arr1[num-10];
        }else if(num<=99){
            int digit=num%10;
            int digit2=(num/10)%10;
            if(digit==0){
                return arr2[digit2];
            }
            return arr2[digit2]+" "+arr[digit];
        }else{
            String str = String.valueOf(num);
            int digi1=str.charAt(0)-'0';
            String res = arr[digi1]+" Hundred "+convert(Integer.valueOf(str.substring(1)));
            return res.trim();
        }
    }
}
