class Solution {
    public List<Integer> filterRestaurants(int[][] A, int vegan, int maxPrice, int maxDistance) {
        Arrays.sort(A, (a, b) -> a[1] == b[1]? b[0] - a[0] : b[1] - a[1]);

        List<Integer> ans = new ArrayList<>();
        for (int[] t : A){
            if (vegan == 1 && t[2] == 0 || t[3] > maxPrice || t[4] > maxDistance) continue;
            ans.add(t[0]);
        }

        return ans;
    }
}
