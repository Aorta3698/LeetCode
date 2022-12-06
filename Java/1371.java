class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        int cur = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
            map.putIfAbsent(cur, i);
            ans = Math.max(ans, i - map.get(cur));
        }

        return ans;
    }
}

class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        int cur = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cur ^= 1 << (ch - 'a');
            }
            map.putIfAbsent(cur, i);
            ans = Math.max(ans, i - map.get(cur));
        }

        return ans;
    }
}
