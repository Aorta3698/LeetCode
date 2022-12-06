class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        if (startFuel >= target) return ans;

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] s : stations){
            if (startFuel >= s[0]) {
                maxheap.offer(s[1]);
                continue;
            }

            while(startFuel < s[0]){
                if (maxheap.isEmpty()) return -1;
                ans++;
                startFuel += maxheap.poll();
            }
            if (startFuel >= target) return ans;
            maxheap.offer(s[1]);
        }

        while(!maxheap.isEmpty()){
            startFuel += maxheap.poll();
            ans++;
            if (startFuel >= target) return ans;
        }

        return -1;
    }
}
