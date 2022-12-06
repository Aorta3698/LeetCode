class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int c = capacity;
        int ans = 0;
        for (int i = 0; i < plants.length; i++){
            if (c < plants[i]){
                c = capacity;
                ans += 2*i;
            }
            c -= plants[i];
            ans++;
        }

        return ans;
    }
}
