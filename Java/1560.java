class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (end >= start){
            for (int i = start; i <= end; i++)
                ans.add(i);
        }else{
            for (int i = 1; i <= end; i++)
                ans.add(i);
            for (int i = start; i <= n; i++)
                ans.add(i);
        }

        return ans;
    }
}
