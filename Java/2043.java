class Bank {

    private long[] nums;
    public Bank(long[] balance) {
        nums = new long[balance.length + 1];
        System.arraycopy(balance, 0, nums, 1, nums.length - 1);
    }

    public boolean transfer(int account1, int account2, long money) {
        return verifyAcc(account2) && withdraw(account1, money) && deposit(account2, money);
    }

    public boolean deposit(int account, long money) {
        if (verifyAcc(account)){
            nums[account] += money;
            return true;
        }

        return false;
    }

    public boolean withdraw(int account, long money) {
        if (hasMoney(account, money)){
            nums[account] -= money;
            return true;
        }

        return false;
    }

    private boolean hasMoney(int account, long money){
        return verifyAcc(account) && nums[account] >= money;
    }

    private boolean verifyAcc(int account){
        return account >= 1 && account <= nums.length;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
