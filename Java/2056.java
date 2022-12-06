https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/discuss/2451262/Confusing-Problem-or-Just-Generate-all-or-Java-90-Speed
class Solution {
    int[][][] all = new int[][][]{
        {{0, 0}, {1, 0}, {-1, 0}, {0, -1}, {0, 1}},
        {{0, 0}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}},
        {{0, 0}, {1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}
    };
    int ROOK   = 0;
    int BISHOP = 1;
    int QUEEN  = 2;
    int[] type;
    int[][] A;
    public int countCombinations(String[] pieces, int[][] positions) {
        A = positions;
        type = new int[pieces.length];
        for (int[] a : A){
            a[0]--; a[1]--;
        }
        for (int i = 0; i < pieces.length; i++){
            type[i] = switch(pieces[i]){
                case "rook"   : yield ROOK;
                case "bishop" : yield BISHOP;
                default       : yield QUEEN;
            };
        }
        return choose(0, new int[A.length], new int[A.length][2]);
    }

    private int choose(int idx, int[] dir, int[][] dest){
        if (idx == A.length){
            return solve(0, dir, dest);
        }
        int ans = 0;
        for (int i = 0; i < all[type[idx]].length; i++){
            int[] d = all[type[idx]][i];
            int nx = A[idx][0] + d[0], ny = A[idx][1] + d[1];
            dir[idx] = i;
            while(nx >= 0 && nx < 8 && ny >= 0 && ny < 8){
                dest[idx][0] = nx; // we can add a check to make sure no dup dest, but it is not really faster.
                dest[idx][1] = ny;
                ans += choose(idx+1, dir, dest);
                if (i == 0){
                    break;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return ans;
    }

    private int solve(int idx, int[] dir, int[][] dest){
        if (idx == A.length){
            boolean ok = true;
            for (int i = 0; i < A.length && ok; i++){
                ok &= A[i][0] == dest[i][0] && A[i][1] == dest[i][1];
            }
            return ok? 1 : solve(0, dir, dest);
        }
        int j = dest[idx][0] == A[idx][0] && dest[idx][1] == A[idx][1]? 0 : dir[idx];
        int[] d = all[type[idx]][j];
        A[idx][0] += d[0];
        A[idx][1] += d[1];
        boolean bad = false;
        for (int i = 0; i < idx && !bad; i++){
            bad |= A[idx][0] == A[i][0] && A[idx][1] == A[i][1];
        }
        int ans = bad? 0 : solve(idx+1, dir, dest);
        A[idx][0] -= d[0];
        A[idx][1] -= d[1];
        return ans;
    }
}
