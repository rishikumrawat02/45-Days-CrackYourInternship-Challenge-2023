class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0; int j=0;
        int res[] = new int[m+n];
        int k=0;
        while(i<m || j<n){
            if(i<m && j<n){
                if(nums1[i]<nums2[j]){
                    res[k++]=nums1[i++];
                }else{
                    res[k++]=nums2[j++];
                }
            }else if(i<m) res[k++]=nums1[i++];
            else res[k++]=nums2[j++];
        }
        for(int i1=0; i1<(m+n); i1++){
            nums1[i1]=res[i1];
        }
    }
}
