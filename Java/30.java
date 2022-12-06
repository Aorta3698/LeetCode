class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int k = words[0].length(), n = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words){
            map.merge(w, 1, Integer::sum);
        }
        for (int i = 0; i < k; i++){
            Map<String, Integer> tmp = new HashMap<>(map);
            for (int j = i+k; j <= s.length(); j+=k){
                String cur = s.substring(j-k, j);
                if (map.merge(cur, -1, Integer::sum)==0){
                    map.remove(cur);
                }
                if ((j-i)/k > n && map.merge(s.substring(j-n*k-k, j-n*k), 1, Integer::sum) == 0){
                    map.remove(s.substring(j-n*k-k, j-n*k));
                }
                if ((j-i)/k >= n && map.size() == 0){
                    ans.add(j-n*k);
                }
            }
            map=tmp;
        }
        return ans;
    }
}
