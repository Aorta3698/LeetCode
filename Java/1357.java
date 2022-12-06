class Cashier {

    private int[] cost;
    private boolean[] dis;
    private double mul;
    private int cnt;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        mul = 1 - discount/100.0;
        cnt = 0;
        cost = new int[201];
        for (int i = 0; i < products.length; i++)
            cost[products[i]] = prices[i];
        dis = new boolean[10001];
        for (int i = n; i < 10001; i += n)
            dis[i] = true;
    }

    public double getBill(int[] product, int[] amount) {
        double ans = 0;
        for (int i = 0; i < product.length; i++)
            ans += cost[product[i]] * amount[i];

        return dis[++cnt]? ans * mul : ans;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
