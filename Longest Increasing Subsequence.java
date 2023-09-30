class Solution {
    class Pair implements Comparable<Pair>{
        int idx, val;
        Pair(int idx, int val){this.idx=idx; this.val=val;}

        public int compareTo(Pair p){
            return this.val-p.val;
        }
    }

    int tree[];

    void update(int l, int r,int pos, int idx, int val){
        if(l==r){
            tree[idx]=val;
            return;
        }
        int mid=(l+r)>>1;
        if(pos<=mid) update(l,mid,pos,2*idx+1,val);
        else update(mid+1,r,pos,2*idx+2,val);
        tree[idx]=Math.max(tree[2*idx+1],tree[2*idx+2]);
        return;
    }

    int query(int l, int r, int qS, int qE, int idx){
        if(qS>qE) return Integer.MIN_VALUE;
        if(l==qS && r==qE) return tree[idx];
        int mid = (l+r)>>1;
        int left = query(l,mid,qS,Math.min(qE,mid),2*idx+1);
        int right = query(mid+1,r,Math.max(qS,mid+1),qE,2*idx+2);
        return Math.max(left,right);
    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        tree = new int[4*n];

        Pair arr[] = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i]=new Pair(i,nums[i]);
        }
        Arrays.sort(arr);

        int position[] = new int[n];
        for(int i=0; i<n; i++){
            position[arr[i].idx]=i;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i].val,i);
        }

        int res=1;

        for(int j=0; j<n; j++){
            Integer lower = (map.lowerKey(nums[j])!=null)? map.get(map.lowerKey(nums[j])):null;
            if(lower==null){
                update(0,n-1,position[j],0,1);
                continue;
            }
            int curRes=1+query(0,n-1,0,lower,0);
            System.out.println(curRes+" "+nums[j]);
            res = Math.max(res,(int)curRes);

            update(0,n-1,position[j],0,curRes);
        }

        return res;       
    }
}
