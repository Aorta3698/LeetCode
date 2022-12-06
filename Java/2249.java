https://leetcode.com/problems/count-lattice-points-inside-a-circle/discuss/1977046/Java-or-Don't-Overthink-It-or-BruteForce
class Solution {
    public int countLatticePoints(int[][] circles) {
        int ans = 0;
        for (int i = 0; i < 201; i++){
            for (int j = 0; j < 201; j++){
                for (int[] c : circles){
                    int x = Math.abs(c[0] - i);
                    int y = Math.abs(c[1] - j);
                    if (c[2] * c[2] >= x * x + y * y){
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
