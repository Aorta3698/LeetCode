class Solution {
    public int longestStrChain(String[] words) {
        int ans = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++){
            int max = 0;
            StringBuilder sb = new StringBuilder(words[i]);
            for (int k = 0; k < words[i].length(); k++){
                sb.deleteCharAt(k);
                max = Math.max(map.getOrDefault(sb.toString(), 0), max);
                sb.insert(k, words[i].charAt(k));
            }

            map.put(words[i], max + 1);
            ans = Math.max(max + 1, ans);
        }

        return ans;
    }
}
