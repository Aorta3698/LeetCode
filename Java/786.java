class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0, hi = arr[arr.length - 1];
        double threshold = 1e-6;
        int[] ans = new int[2];
        while(hi-lo > threshold){
            double top = (lo+hi)/2;
            int count = 0;
            for (int i = 0; i < arr.length; i++){
                int low = 0;
                int high = arr.length;
                while(low < high){
                    int mid = (low+high)>>1;
                    double res = 1d*arr[mid]/arr[i];
                    if (res>top){
                        high=mid;
                    }else{
                        low=mid+1;
                    }
                    if (Math.abs(res-top)<threshold){
                        ans[0]=arr[mid];
                        ans[1]=arr[i];
                    }
                }
                count += low;
            }
            if (count >= k){
                hi = top;
            }else{
                lo = top;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingDouble(o -> 1d*arr[o[0]]/o[1]));
//         for (int i = 0; i< arr.length; i++){
//             minheap.offer(new int[]{0, arr[i]});
//         }
//         while(--k>0){
//             int[] cur = minheap.poll();
//             if (++cur[0]<arr.length){
//                 minheap.offer(cur);
//             }
//         }
//         int[] ans = minheap.poll();
//         return new int[]{arr[ans[0]], ans[1]};
//     }
// }
