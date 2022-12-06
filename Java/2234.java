class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int lo = Arrays.stream(flowers).min().getAsInt(), hi = target - 1;
        long left = newFlowers;
        while(lo < hi){
            int mid = (lo+hi+1)>>1;
            long cost = 0;
            for (int n : flowers){
                cost += Math.max(0, mid-n);
            }
            if (cost <= newFlowers){
                left = newFlowers-cost;
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        if (lo >= target){
            return 1L*full*flowers.length;
        }
        long ans = 1L*lo*partial;
        Arrays.sort(flowers);
        for (int i = flowers.length-1,j=i; i >= 0 && left >= 0; i--){
            j = Math.min(i-1, j);
            if (flowers[i] < target){
                left -= (target - Math.max(lo, flowers[i]));
                while(left < 0 && j >= 0){
                    if (lo>flowers[j]){
                        left += j+1;
                        lo--;
                    }else{
                        j--;
                    }
                }
            }
            if (left >= 0){
                ans = Math.max(ans, 1L*(flowers.length-i)*full + 1L*(i==0?0:lo)*partial);
            }
        }
        return ans;
    }
}


// This is OK but a bit hard to implement
//
// class Solution {
//     public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
//         int lo = Arrays.stream(flowers).min().getAsInt(), hi = target - 1;
//         while(lo < hi){
//             int mid = (lo+hi+1)>>1;
//             long cost = 0;
//             for (int n : flowers){
//                 cost += Math.max(0, mid-n);
//             }
//             if (cost <= newFlowers){
//                 lo=mid;
//             }else{
//                 hi=mid-1;
//             }
//         }
//         if (lo >= target){
//             return 1L*full*flowers.length;
//         }
//         int cap = 0, fc = 0;
//         long left = newFlowers;
//         var maxheap = new PriorityQueue<Integer>(Comparator.comparingInt(o -> -flowers[o]));
//         var able    = new TreeSet<Integer>(Comparator.<Integer>comparingInt(o -> -flowers[o]).thenComparingInt(o -> o));
//         for (int i = 0; i < flowers.length; i++){
//             if (flowers[i] >= target){
//                 ++fc;
//             }else{
//                 maxheap.offer(i);
//             }
//             if (flowers[i] < lo){
//                 able.add(i);
//                 left -= (lo - flowers[i]);
//             }
//         }
//         long ans = 1L*lo * partial + 1L*fc * full;
//         while(!maxheap.isEmpty() && left >= 0){
//             int cur = maxheap.poll();
//             int req = target - Math.max(lo, flowers[cur]);
//             able.remove(cur);
//             while (left < req && !able.isEmpty()){
//                 if (lo == flowers[able.first()]){
//                     able.pollFirst();
//                     continue;
//                 }
//                 long a = ((req-left-1)/able.size())+1;
//                 if (lo-a >= flowers[able.first()]){
//                     lo-=a;
//                     left += a*able.size();
//                 }else{
//                     left += 1L*able.size() * (lo - flowers[able.first()]);
//                     lo = flowers[able.pollFirst()];
//                 }
//             }
//             left -= req;
//             if (left >= 0){
//                 if (++fc == flowers.length){
//                     lo=0;
//                 }
//                 ans = Math.max(ans, 1L*lo*partial + 1L*fc*full);
//             }
//         }
//         return ans;
//     }
// }
