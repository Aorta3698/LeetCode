class Solution {
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        int cur = 0;

        for (char ch : word.toCharArray()){
            cur ^= (1 << (ch - 'a'));
            for (int i = 0; i < 10; i++){
                ans += map.getOrDefault(cur ^ (1 << i), 0);
            }
            ans += map.getOrDefault(cur, 0);
            map.merge(cur, 1, Integer::sum);
        }
        //a ^ b = t
        //a ^ b ^ t = t ^ t = 0
        //a ^ b ^ b ^ t = a ^ t = t ^ t ^ b = b

        return ans;
    }
}
