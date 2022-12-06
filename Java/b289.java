class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks){
            map.merge(t, 1, Integer::sum);
        }
        int ans = 0;
        for (int key : map.keySet()){
            int val = map.get(key);
            if (val == 1)
                return -1;
            ans += val / 3;
            if (val % 3 == 1 || val % 3 == 2)
                ans++;
        }
        return ans;
    }
}
