class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE, count = 0;
        for (int[] mat : matrix){
            for (int m : mat){
                sum += Math.abs(m);
                min = Math.min(Math.abs(m), min);
                if (m < 0){
                    count++;
                }
            }
        }

        return count % 2 == 0? sum : sum - 2*min;
    }
}
