class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words1) map.merge(w, 1, Integer::sum);

        HashMap<String, Integer> second = new HashMap<>();
        for (String w : words2) second.merge(w, 1, Integer::sum);

        int ans = 0;
        for (String w : words1){
            if (map.get(w) == 1 && second.containsKey(w) && second.get(w) == 1) ans++;
        }

        return ans;
    }
}
