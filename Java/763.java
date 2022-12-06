class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int cur = 0, need = 0;
        int[] copy = count.clone();
        for (char ch : s.toCharArray()){
            ++cur;
            if (copy[ch - 'a'] == count[ch - 'a']){
                ++need;
            }
            if (--count[ch - 'a'] == 0){
                --need;
            }
            if (need == 0){
                ans.add(cur);
                cur = 0;
            }
        }

        return ans;
    }
}
