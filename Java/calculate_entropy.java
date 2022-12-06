class Solution {
    public double calculateEntropy(int[] input) {
        double ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : input)
            map.merge(i, 1, Integer::sum);
        for (int i : map.values()){
            double p = (double) i / input.length;
            ans -= p * Math.log(p)/Math.log(2);
        }

        return ans;
    }
}
