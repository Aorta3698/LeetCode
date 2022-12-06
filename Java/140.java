class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, String> words = new HashMap<>();
        for (String w : wordDict){
            int hash = 0;
            for (char ch : w.toCharArray()){
                hash = 31 * hash + ch - 'a' + 1;
            }
            words.put(hash, w);
        }
        return solve(0, s, words, new HashMap<>(Map.of(s.length(), List.of(""))));
    }

    private List<String> solve(int i, String s, Map<Integer, String> map, Map<Integer, List<String>> memo){
        if (memo.containsKey(i))
            return memo.get(i);

        List<String> ans = new ArrayList<>();
        for (int j = i, hash = 0; j < s.length(); j++){
            hash = 31 * hash + s.charAt(j) - 'a' + 1;
            if (map.containsKey(hash)){
                for (String next : solve(j+1, s, map, memo)){
                    ans.add(next.isEmpty()? map.get(hash) : map.get(hash) + " " + next);
                }
            }
        }
        memo.put(i, ans);
        return ans;
    }
}
