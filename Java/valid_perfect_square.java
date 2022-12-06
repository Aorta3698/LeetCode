class Solution {
    public boolean isPerfectSquare(int num) {
        int hi = num;
        int lo = 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            long sq = (long)mid*mid;
            if (sq == num) return true;
            if (sq > num) hi = mid - 1;
            if (sq < num) lo = mid + 1;
        }

        return false;
    }
}
