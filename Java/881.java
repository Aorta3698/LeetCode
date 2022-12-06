class Solution {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> weight = new TreeMap<>();
        for (int n : people){
            weight.merge(n , 1, Integer::sum);
        }

        int ans = 0;
        for (int n : people){
            if (!weight.containsKey(n)){
                continue;
            }
            if (weight.merge(n, -1, Integer::sum) == 0){
                weight.remove(n);
            }
            Integer pair = weight.floorKey(limit - n);
            if (pair != null && weight.merge(pair, -1, Integer::sum) == 0){
                weight.remove(pair);
            }
            ans++;
        }

        return ans;
    }
}
