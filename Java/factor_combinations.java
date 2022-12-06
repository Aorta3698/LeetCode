class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        build(n, 2, new LinkedList<>(), ans, true);

        return ans;
    }

    public void build(int n, int cur, LinkedList<Integer> sub, List<List<Integer>> ans, boolean first){
        if (n == 1){
            if (!sub.isEmpty())
                ans.add(new ArrayList<>(sub));
            return;
        }

        int upper = first? n/2 : n;
        for (int i = cur; i <= upper; i++){
            if (n % i == 0){
                sub.add(i);
                build(n / i, i, sub, ans, false);
                sub.removeLast();
            }
        }
    }
}
