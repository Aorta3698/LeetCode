class ATM {

    long[] count;
    int[] values;
    public ATM() {
        count = new long[5];
        values = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++){
            count[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for (int i = 4; i >= 0; i--){
            if (amount >= values[i]){
                long take = Math.min(count[i], amount / values[i]);
                amount -= values[i] * take;
                count[i] -= take;
                ans[i] = (int)take;
            }
        }
        if (amount > 0){
            deposit(ans);
            return new int[]{-1};
        }

        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
