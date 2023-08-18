class Solution {
    public int reversePairs(int[] nums) {
        int res = mergeSort(0,nums.length-1,nums);
        return res;
    }

    int mergeSort(int low, int high, int []nums){
        if(low==high) return 0;
        int cnt=0;
        int mid=(low+high)/2;
        cnt+= mergeSort(low,mid,nums);
        cnt+= mergeSort(mid+1,high,nums);
        cnt+= count(low,high,nums);
        merge(low,high,nums);
        return cnt;
    }

    int count(int low, int high, int nums[]){
        int mid=(low+high)/2; int res=0;
        for(int i=low; i<=mid; i++){
            int idx=search(mid+1,high,nums,nums[i]);
            res+=(high-idx+1);
        }
        return res;
    }

    int search(int left, int right, int nums[], int val){
        int res=right+1;
        while(left<=right){
            int mid=(left+right)/2;
            if(val>2l*nums[mid]){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    void merge(int low, int high, int[] nums){
        int mid=(low+high)/2;
        int arr[] = new int[high-low+1];
        int i=low; int j=mid+1; int k=0;
        while(i<=mid && j<=high){
            if(nums[i]>=nums[j]){
                arr[k++]=nums[i++];
            }else{
                arr[k++]=nums[j++];
            }
        }
        while(i<=mid) arr[k++]=nums[i++];
        while(j<=high) arr[k++]=nums[j++];
        for(int i1=0; i1<arr.length; i1++){
            nums[i1+low]=arr[i1];
        }
        return;
    }
}
