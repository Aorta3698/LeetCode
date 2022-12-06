class Solution {
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] hash = new int[m];
        int p = 31, mod = (int)1e9 + 7;
        Map<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < m; i++){
            int h = 0;
            for (int j = 0; j < n; j++){
                h = (h * p + picture[i][j]) % mod;
                if (picture[i][j] == 'B'){
                    col.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
                    row[i]++;
                }
            }
            hash[i] = h;
        }

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] == 'B' && row[i] == target && col.get(j).size() == target){
                    int add = 1;
                    for (int v : col.get(j)){
                        if (hash[v] != hash[i])
                            add = 0;
                    }
                    ans += add;
                }
            }
        }

        return ans;
    }
}
