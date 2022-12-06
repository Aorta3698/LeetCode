class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char prev = s.charAt(0);
        for (int i = 1, cnt = 1; i < s.length(); prev = s.charAt(i++), cnt++){
            if (prev != s.charAt(i) && cnt >= 3) ans.add(List.of(i - cnt, i - 1));
            if (prev != s.charAt(i)) cnt = 0;
            if (i == s.length() - 1 && cnt >= 2) ans.add(List.of(i - cnt, i));
        }

        return ans;
    }
}
