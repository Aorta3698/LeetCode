class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] map = new int[1001];
        for (int[] a : items1){
            map[a[0]]+=a[1];
        }
        for (int[] a : items2){
            map[a[0]]+=a[1];
        }
        for (int i = 0; i < 1001; i++){
            if (map[i]>0){
                ans.add(List.of(i, map[i]));
            }
        }
        return ans;
    }
}
