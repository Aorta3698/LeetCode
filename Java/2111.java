class Solution {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j+=k){
                ans++;
                int lo = 0, hi = list.size();
                while(lo < hi){
                    int mid = (lo+hi)>>1;
                    if (list.get(mid) > arr[j]){
                        hi=mid;
                    }else{
                        lo=mid+1;
                    }
                }
                if (lo==list.size()){
                    list.add(arr[j]);
                }else{
                    list.set(lo, arr[j]);
                }
            }
            ans-=list.size();
        }
        return ans;
    }
}
