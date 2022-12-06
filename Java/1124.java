class Solution {
    public int longestWPI(int[] hours) {
        int ans = 0, pre = 0, n = hours.length;
        int[] prefix = new int[n];
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        for (int i = 0; i < hours.length; i++){
            pre += hours[i] > 8? 1 : -1;
            prefix[i] = pre;
            map.putIfAbsent(pre, i);
        }

        int[] res = new int[20001];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < res.length; i++){
            res[i] = Math.min(res[i > 0? i - 1 : i], map.getOrDefault(i - 10000, Integer.MAX_VALUE));
        }

        for (int i = n - 1; i >= 0; i--){
            ans = Math.max(ans, i - res[prefix[i] + 9999]);
        }

        return ans;
    }
}
        // 0, 1, 2, 1, 0, -1, -2, -1
        // 0 -> -1
        // 1 -> 0
        // 2 -> 1
        // -1 -> 4
        // -2 -> 5

