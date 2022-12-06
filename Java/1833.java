class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        for (;i < costs.length && coins >= costs[i]; coins -= costs[i++]);
        return i;
    }
}
