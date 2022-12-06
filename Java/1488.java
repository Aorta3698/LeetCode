class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zero = new TreeSet<>();

        for (int i = 0; i < rains.length; i++){
            if (rains[i] == 0){
                zero.add(i);
                ans[i] = 1;
                continue;
            }
            if (!map.containsKey(rains[i])){
                map.put(rains[i], i);
                continue;
            }

            Integer idx = zero.ceiling(map.get(rains[i]));
            if (idx == null){
                return new int[]{};
            }
            ans[idx] = rains[i];
            zero.remove(idx);
            map.put(rains[i], i);
        }

        return ans;
    }
}
