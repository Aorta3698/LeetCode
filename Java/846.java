https://leetcode.com/problems/hand-of-straights/discuss/1861681/Java-No-Nested-for-loop-or-Sliding-Window
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int h : hand){
            map.merge(h, 1, Integer::sum);
        }

        int need = 0, prev = 0;
        for (int cur : map.keySet()){
            int count = map.get(cur);
            if (need > count || need > 0 && cur - prev > 1){
                return false;
            }
            map.merge(cur, -need, Integer::sum);
            need = count - map.getOrDefault(cur - groupSize + 1, 0);
            prev = cur;
        }

        return need == 0;
    }
}
