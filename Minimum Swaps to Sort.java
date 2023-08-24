class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public class Pair implements Comparable<Pair>{
        int value; int index;
        Pair(int v, int i){
            value=v; index=i;
        }
        public int compareTo(Pair p){
            return this.value-p.value;
        }
    }
    
    public int minSwaps(int nums[])
    {
        // Code here
        int n=nums.length;
        Pair[] arr=new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr);
        boolean visited[] = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(visited[i]==true || arr[i].index==i){
                continue;
            }
            int cylen=0; int j=i;
            while(visited[j]==false){
                visited[j]=true;
                cylen++;
                j=arr[j].index;
            }
            ans+=cylen-1;
        }
        return ans;
    }
}
