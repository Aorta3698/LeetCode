class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        var map = new TreeMap<Integer, List<int[]>>();
        int L = 1, R = -1, prev = 0;
        for (int[] b : buildings){
            int l = b[0], r = b[1], h = b[2];
            map.computeIfAbsent(l, o -> new ArrayList<>()).add(new int[]{h, L});
            map.computeIfAbsent(r, o -> new ArrayList<>()).add(new int[]{h, R});
        }
        TreeMap<Integer, Integer> height = new TreeMap<>();
        height.put(0, 0);
        for (int x : map.keySet()){
            for (int[] e : map.get(x)){
                if (height.merge(e[0], e[1], Integer::sum) == 0){
                    height.remove(e[0]);
                }
            }
            int y = height.lastKey();
            if (prev != y){
                ans.add(List.of(x, y));
            }
            prev = y;
        }
        return ans;
    }
}




class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length, STT = 1, END = -1, idx = 0;
        int[][] cor = new int[2*n][3];
        for (int[] b : buildings){// start or end, x coordinate, height
            cor[idx++] = new int[]{STT, b[0], b[2]};
            cor[idx++] = new int[]{END, b[1], b[2]};
        }

        Arrays.sort(cor, (a, b) ->{
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] == STT && b[0] == STT) return Integer.compare(b[2], a[2]);
            if (a[0] == END && b[0] == END) return Integer.compare(a[2], b[2]);
            return Integer.compare(b[0], a[0]);
        });

        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int max = 0;
        for (int[] c : cor){
            int type = c[0], x = c[1], y = c[2];
            if (cntMap.merge(y, type, Integer::sum) == 0) cntMap.remove(y);
            int curMax = cntMap.isEmpty()? 0 : cntMap.lastKey();
            if (curMax != max){
                max = curMax;
                ans.add(List.of(x, max));
            }
        }

        return ans;
    }
}
