class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points){
            map.computeIfAbsent(p[1], o -> new HashSet<>()).add(p[0]);
        }

        int mid = Integer.MAX_VALUE;
        for (int y : map.keySet()){
            List<Integer> cur = new ArrayList<>(map.get(y));
            Collections.sort(cur);
            if (mid == Integer.MAX_VALUE){
                mid = cur.get(0) + cur.get(cur.size() - 1);
            }
            for (int i = 0; i <= cur.size() / 2; i++){
                if (cur.get(i) + cur.get(cur.size() - 1 - i) != mid){
                    return false;
                }
            }
        }

        return true;
    }
}
