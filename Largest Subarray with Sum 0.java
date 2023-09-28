

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int curSum=0; int res=0;
        for(int i=0; i<n; i++){
            curSum+=arr[i];
            if(map.containsKey(curSum)){
                res=Math.max(res,i-map.get(curSum));
            }else{
                map.put(curSum,i);
            }
        }return res;
    }
}
