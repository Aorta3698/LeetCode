class Solution {
    public double averageWaitingTime(int[][] customers) {
        double elapsed = 0;
        int t = customers[0][0];
        for (int[] c : customers){
            elapsed += Math.max(t - c[0], 0);
            t = Math.max(c[0], t);
            t += c[1];
            elapsed += c[1];
        }

        return elapsed / customers.length;
    }
}
