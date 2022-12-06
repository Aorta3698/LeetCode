https://leetcode.com/problems/minimize-rounding-error-to-meet-target/discuss/2003178/Java-or-MaxHeap-(PriorityQueue)-or-with-Comments
class Solution {
    public String minimizeError(String[] prices, int target) {
        int lo = 0, hi = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (String p : prices){
            int head = Integer.parseInt(p.substring(0, p.length()-4));
            int tail = Integer.parseInt(p.substring(p.length()-3));
            lo += head;
            hi += head;
            if (tail > 0){
                hi++;
                maxheap.offer(tail);
            }
        }
        if (target < lo || target > hi)
            return "-1";

        int ans = 0;
        for (int i = 0; i < target - lo; i++){
            ans += 1000 - maxheap.poll();
        }
        while(!maxheap.isEmpty()){
            ans += maxheap.poll();
        }
        return String.format("%.03f", 1.0*ans/1000);
    }
}
