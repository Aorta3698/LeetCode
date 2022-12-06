class Solution {
    public boolean checkPowersOfThree(int n) {
        return find(0, 0, n);
    }

    private static boolean find(int idx, int sum, int target){
        if (sum == target) return true;
        if (sum > target) return false;
        if (idx > (int)(Math.log(target) / Math.log(3))) return false;

        if (find(idx + 1, sum, target)) return true;
        if (find(idx + 1, sum + (int)Math.pow(3, idx), target)) return true;
        return false;
    }
}
