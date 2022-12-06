class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for(int i = 0; candies > 0; i++){
            for (int j = 0; j < num_people && candies > 0; j++){
                int get = Math.min(candies, j + 1 + i * num_people);
                candies -= get;
                ans[j] += get;
            }
        }

        return ans;
    }
}
