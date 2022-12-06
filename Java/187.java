https://leetcode.com/problems/repeated-dna-sequences/discuss/1856110/Java-Concise-Bit-solution
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int cur = 0;
        int[] pos = new int[128];
        pos['A'] = 0; pos['C'] = 1; pos['G'] = 2; pos['T'] = 3;
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            cur = ((cur << 2) + pos[s.charAt(i)]) % (1 << 20);
            if (i >= 9 && map.merge(cur, 1, Integer::sum) == 2){
                ans.add(s.substring(i - 9, i + 1));
            }
        }

        return ans;
    }
}
