https://leetcode.com/problems/binary-watch/discuss/1642374/Java-or-Just-Try-All-Combinations
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            int cnt = Integer.bitCount(i);
            if (cnt > turnedOn) continue;
            for (int j = 0; j < 60; j++){
                if (Integer.bitCount(j) + cnt == turnedOn)
                    ans.add(i + ":" + String.format("%02d", j));
            }
        }

        return ans;
    }
}
