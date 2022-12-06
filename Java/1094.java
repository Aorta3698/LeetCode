class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] range = new int[1001];
        for (int[] t : trips){
            range[t[1]] += t[0];
            range[t[2]] -= t[0];
        }

        int sum = 0;
        for (int i = 0; i < 1001 && sum <= capacity; i++){
            sum += range[i];
        }

        return sum <= capacity;
    }
}
