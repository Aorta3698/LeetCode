class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> diag = new HashMap<>();
        HashMap<Integer, Integer> antiDiag = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashSet<Map.Entry<Integer, Integer>> lamp = new HashSet<>();
        int[] ans = new int[queries.length];

        for (int[] pos : lamps){
            int r = pos[0];
            int c = pos[1];
            if (lamp.contains(Map.entry(r, c))) continue;
            diag.put(r + c, diag.getOrDefault(r + c, 0) + 1);
            antiDiag.put(r - c, antiDiag.getOrDefault(r - c, 0) + 1);
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            lamp.add(Map.entry(r, c));
        }

        int idx = 0;
        for (int[] query : queries){
            int r = query[0];
            int c = query[1];
            ans[idx++] = (diag.getOrDefault(r + c, 0) + antiDiag.getOrDefault(r - c, 0)
                    + row.getOrDefault(r, 0) + col.getOrDefault(c, 0) > 0)? 1 : 0;

            List<int[]> remove = getLamps(n, r, c, lamp);
            for (int[] pos : remove){
                int a = pos[0];
                int b = pos[1];
                diag.put(a + b, diag.get(a + b) - 1);
                antiDiag.put(a - b, antiDiag.get(a - b) - 1);
                row.put(a, row.get(a) - 1);
                col.put(b, col.get(b) - 1);
                lamp.remove(Map.entry(a, b));
            }
        }

        return ans;
    }

    private List<int[]> getLamps(int n, int r, int c, Set<Map.Entry<Integer, Integer>> lamps){
        int startRow = r == 0? 0 : r - 1;
        int endRow = r == n - 1? n - 1 : r + 1;
        int startCol = c == 0? 0 : c - 1;
        int endCol = c == n - 1? n - 1 : c + 1;
        List<int[]> ans = new ArrayList<>();

        for (int i = startRow; i <= endRow; i++)
            for (int j = startCol; j <= endCol; j++)
                if (lamps.contains(Map.entry(i, j)))
                    ans.add(new int[]{i, j});

        return ans;
    }
}
