https://leetcode.com/problems/count-pairs-of-equal-substrings-with-minimum-difference/discuss/1655332/Java-or-ONLY-1-Character-Matters-or-Explained.
class Solution {
    public int countQuadruples(String f, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < f.length(); i++)
            map.putIfAbsent(f.charAt(i), i);

        int ans = 0;
        for (int i = s.length() - 1, min = Integer.MAX_VALUE; i >= 0 && min >= -i; i--){
            if (!map.containsKey(s.charAt(i))) continue;
            if (map.get(s.charAt(i)) - i < min){ans = 1; min = map.get(s.charAt(i)) - i;}
            else if (map.get(s.charAt(i)) - i == min) ans++;
        }

        return ans;
    }
}
