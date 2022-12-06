class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        for (int n : flowers){
            if (n >= target){
                count++;
            }else{
                maxheap.offer(n);
            }
        }

        int lo = 0, hi = target - 1;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            long m = 0;
            for (int n : flowers){
                if (n >= target)
                    continue;
                m += n - mid;
            }
            if (m <= newFlowers)
                lo = mid;
            else
                hi = mid - 1;
        }

        long excess = newFlowers;
        for (int n : flowers){
            if (n >= target)
                continue;
            excess -= (lo - n);
        }

        long ans = lo * partial;
        int j = 0;
        while(!maxheap.isEmpty()){
            int need = target - maxheap.poll();
            if (need > excess){
                need -= excess;
                int d = need / flowers.length + (need % flowers.length == 0? 0 : 1);
                lo -= d;
                excess = need % flowers.length == 0? 0 : flowers.length - need % flowers.length;
            }
            if (maxheap.size() > 1)
            ans = Math.max(ans, lo * partial + ++j*full);
            else
                ans = Math.max(ans, ++j * full);
        }

        return ans + count * full;
    }
}
