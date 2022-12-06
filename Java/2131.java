class Solution {
    public int longestPalindrome(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, oddCnt = 0;
        for (String w : words){
            if (w.charAt(0) == w.charAt(1)){
                int even = map.merge(w.hashCode(), 1, Integer::sum) % 2;
                ans += 4 * (1 - even);
                oddCnt += even == 0? -1 : 1;
                continue;
            }
            int pair = map.getOrDefault(reverse(w).hashCode(), 0);
            if (map.merge(w.hashCode(), 1, Integer::sum) <= pair && pair > 0) ans += 4;
        }

        return ans + (oddCnt > 0? 2 : 0);
    }

    private String reverse(String s){
        char[] arr = new char[]{s.charAt(1), s.charAt(0)};
        return String.valueOf(arr);
    }
}
