class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) if(valid(i)) count++;
        return count;
    }

    private boolean valid(int n){
        boolean diff = false;
        while(n > 0){
            int d = n % 10;
            if (d == 3 || d == 4 || d == 7) return false;
            if (!diff && (d == 2 || d == 5 || d == 6 || d == 9)) diff = true;
            n /= 10;
        }

        return diff;
    }
}
