class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs (int[] arr, int idx, boolean[] seen){
        if (idx < 0 || idx >= arr.length || seen[idx]) return false;
        if (arr[idx] == 0) return true;
        seen[idx] = true;
        return dfs(arr, idx + arr[idx], seen) || dfs(arr, idx - arr[idx], seen);
    }
}
