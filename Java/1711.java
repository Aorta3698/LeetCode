https://leetcode.com/problems/count-good-meals/discuss/1847649/Java-or-99.02-Speed-or-Map-or-Brief-Explanation.
class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : deliciousness){
            map.merge(n, 1, Integer::sum);
        }

        long ans = 0;
        for (int key : map.keySet()){
            int i = 1, cur = map.get(key);
            while(key > i - key) i <<= 1;
            while(i <= (1 << 21)){
                ans += (key != i - key?
                        1L * cur * map.getOrDefault(i - key, 0) :
                       (1L * cur * (cur - 1)) / 2);
                i <<= 1;
            }
        }

        return (int)(ans % (int)(1e9+7));
    }
}
