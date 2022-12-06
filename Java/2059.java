class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] seen = new boolean[1001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        seen[start] = true;
        int ans = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.poll();
                for (int n : nums){
                    for (int next : new int[]{cur + n, cur - n, cur ^ n}){
                        if (next == goal)
                            return ++ans;
                        if (next >= 0 && next <= 1000 && !seen[next]){
                            seen[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
