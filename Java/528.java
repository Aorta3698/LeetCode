class Solution {

    private BitSet bit;
    private int sum;
    private Map<Integer, Integer> map;
    private Random random;
    public Solution(int[] w) {
        bit = new BitSet();
        map = new HashMap<>();
        random = new Random();
        sum = -1;

        int i = 0;
        for (int n : w){
            sum += n;
            bit.set(sum);
            map.put(sum, i++);
        }
    }

    public int pickIndex() {
        return map.get(bit.nextSetBit(random.nextInt(sum + 1)));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
