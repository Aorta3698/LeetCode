https://leetcode.com/problems/bulb-switcher-ii/discuss/1633645/Java-or-O(1)-or-Observation
class Solution {
    public int flipLights(int n, int presses) {
        //1, 2 -> 3
        //1, 3 -> 2
        //2, 3 -> 1
        //all on, all off, even on, odd on, 3k+1 on, 3k,1,2 on, 3k+1 w/ 2, 3k+1 w/ 3
        //1, 1
        //1, 2
        //1, 3
        //1, 4
        //4
        //
        if (n == 2 && presses == 1) return 3;
        if (presses == 1) return Math.min(1 << Math.min(4, n), 4);
        if (presses == 2) return Math.min(1 << Math.min(4, n), 7);
        if (presses >= 3) return Math.min(1 << Math.min(4, n), 8);
        return 1;
    }
}
