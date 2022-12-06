class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>(List.of(1));
        while(numRows-- > 0){
            ans.add(prev);

            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int i = 0; i < prev.size() - 1; i++)
                next.add(prev.get(i) + prev.get(i + 1));
            next.add(1);

            prev = next;
        }

        return ans;
    }
}
