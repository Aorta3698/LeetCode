class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat[0].length; i++){
            boolean allFound = true;
            for (int j = 1; j < mat.length; j++){
                int lo = map.getOrDefault(i - 1 + mat[0].length * j, 0);
                int hi = mat[0].length - 1;
                boolean found = false;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if (mat[j][mid] == mat[0][i]){found = true; break;}
                    if (mat[j][mid] > mat[0][i]) hi = mid - 1;
                    if (mat[j][mid] < mat[0][i]) lo = mid + 1;
                }

                map.put(i + mat[0].length * j, lo);
                if (!found) {allFound = false; break;}
            }
            if (allFound) return mat[0][i];
        }

        return -1;
    }
}
