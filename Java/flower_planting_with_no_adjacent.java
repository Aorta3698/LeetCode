class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] garden = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : paths){
            map.computeIfAbsent(p[0] - 1, o -> new ArrayList<>()).add(p[1] - 1);
            map.computeIfAbsent(p[1] - 1, o -> new ArrayList<>()).add(p[0] - 1);
        }

        for (int i = 0; i < garden.length; i++){
            int type = 0;
            if (map.containsKey(i))
                for (int nei : map.get(i)) type |= 1 << garden[nei];
            type >>= 1;
            type = (int)(Math.log(~type & -~type)/Math.log(2)) + 1;
            garden[i] = type;
        }

        return garden;
    }
}
