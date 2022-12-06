https://leetcode.com/problems/naming-a-company/discuss/2248917/Group-by-Suffix-or-Bitmask-or-70-speed-or-Java
class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (String s : ideas){
            map.merge(s.substring(1), 1<<s.charAt(0)-'a', Integer::sum);
        }
        int[][] count = new int[26][26];
        for (int val : map.values()){
            for (int i = 0; i < 26; i++){
                if ((val&(1<<i))==0){
                    for (int j = 0; j < 26; j++){
                        count[i][j]+=(val&(1<<j))>0?1:0;
                    }
                }
            }
        }
        for (int val : map.values()){
            for (int i = 0; i < 26; i++){
                if ((val&(1<<i))>0){
                    for (int j = 0; j < 26; j++){
                        if ((val&(1<<j))==0){
                            ans += count[i][j];
                        }
                    }
                }
            }
        }
        return ans;
    }
}
