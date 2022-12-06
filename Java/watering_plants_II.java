class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int n = plants.length;
        int[] can = new int[]{capacityA, capacityB};
        for (int i = 0; i < n / 2; i++){
            int j = n - 1 - i;
            if (can[0] < plants[i]){
                ans++;
                can[0] = capacityA;
            }

            if (can[1] < plants[j]){
                ans++;
                can[1] = capacityB;
            }

            can[0] -= plants[i];
            can[1] -= plants[j];
        }

        return n % 2 == 0? ans : ans + (plants[n / 2] > Math.max(can[0], can[1])? 1 : 0);
    }
}
