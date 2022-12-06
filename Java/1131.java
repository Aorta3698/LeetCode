https://leetcode.com/problems/maximum-of-absolute-value-expression/discuss/2002920/Java-or-My-Take
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        return Math.max(Math.max(solve(1, arr1, arr2), solve(2, arr1, arr2)),
                        Math.max(solve(3, arr1, arr2), solve(4, arr1, arr2)));
    }

    private int solve(int p, int[] A, int[] B){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++){
            int val = switch(p){
                case 1: yield A[i] + B[i] + i;
                case 2: yield A[i] - B[i] + i;
                case 3: yield -A[i]+ B[i] + i;
                default: yield -(A[i]+B[i])+ i;
            };
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        return max - min;
    }
}
