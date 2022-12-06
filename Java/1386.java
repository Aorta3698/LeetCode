class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] re : reservedSeats){
            map.computeIfAbsent(re[0], o -> new HashSet<>()).add(re[1]);
        }
        for (int key : map.keySet()){
            Set<Integer> row = map.get(key);
            boolean[] avail = new boolean[3];
            Arrays.fill(avail, true);
            for (int s : row){
                if (s >= 2 && s <= 5){
                    avail[0] = false;
                }
                if (s >= 4 && s <= 7){
                    avail[1] = false;
                }
                if (s >= 6 && s <= 9){
                    avail[2] = false;
                }
            }
            if (avail[2] || avail[0]){
                avail[1] = false;
            }
            int count = 0;
            for (boolean a : avail){
                if (a){
                    count++;
                }
            }

            ans -= Math.max(2 - count, 0);
        }

        return ans + 2 * n;
    }
}
