class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int n : asteroids){
            if (n > m) return false;
            else m += n;
        }

        return true;
    }
}
