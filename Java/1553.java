class Solution {
    public int minDays(int n) {
        return solve(n, new HashMap<>())-1;
    }

    private int solve(int n, Map<Integer, Integer> map){
        if (n==0){
            return 0;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int ans = Math.min(n%2+solve(n/2,map),n%3+solve(n/3,map))+1;
        map.put(n, ans);
        return ans;
    }
}
