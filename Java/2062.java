class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        String vowels = "aeiou";
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = -1; i < word.length(); i++){
            int found = vowels.indexOf(word.charAt(i));
            if (found == -1){
                map.clear();
                j = i;
            }else{
                map.put(found, i);
            }
            if (map.size() == 5){
                ans += map.values().stream().min(Integer::compare).get() - j;
            }
        }

        return ans;
    }
}
