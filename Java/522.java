https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/1638977/Java-or-O(10NX)-or-Two-solution-or-15-Lines-or-Explained
class Solution {
    public int findLUSlength(String[] strs) {
        List<Integer>[] idx = new ArrayList[11];
        for (int i = 1; i <= 10; i++) idx[i] = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String max = strs[0];
        for (int i = 0; i < strs.length; i++) {
            map.merge(strs[i].hashCode(), 1, Integer::sum);
            idx[strs[i].length()].add(i);
            if (strs[i].length() > max.length()) max = strs[i];
        }

        for (int i = 10; i > 0; i--){
            for (int j : idx[i]){
                if (map.get(strs[j].hashCode()) == 1 && (i == max.length() || check(max, strs[j])))
                    return i;
            }
        }

        return -1;

        // Arrays.sort(strs, (a, b) -> (b.length() - a.length()));
        // Map<Integer, Integer> map = new HashMap<>();
        // for (String s : strs) map.merge(s.hashCode(), 1, Integer::sum);
        // for (String s : strs){
        //     if (map.get(s.hashCode()) > 1) continue;
        //     if (s.length() == strs[0].length()) return s.length();
        //     if (check(strs[0], s)) return s.length();
        // }

        // return -1;
    }

    private static boolean check(String a, String b){
        int start = 0;
        for (int i = 0; i < a.length() && start < b.length(); i++)
            if (a.charAt(i) == b.charAt(start))
                start++;

        return start != b.length();
    }
}
