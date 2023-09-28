class Solution {
    class Pair{
        int freq; int val;
        Pair(int freq, int val){
            this.freq=freq; this.val=val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->b.freq-a.freq);
        for(Map.Entry<Integer,Integer> mp: map.entrySet()){
            q.add(new Pair(mp.getValue(),mp.getKey()));
        }    

        int res[] = new int[k];
        while(k>0){
            res[k-1]=q.poll().val;
            k--;
        }    
        return res;
    }
}
