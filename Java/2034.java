class StockPrice {

    TreeMap<Integer, Integer> countMap; // price -> count
    Map<Integer, Integer> priceMap;     // time -> price
    int max;

    public StockPrice() {
        countMap = new TreeMap<>();
        priceMap = new HashMap<>();
        max = 0;
    }

    public void update(int timestamp, int price) {
        max = Math.max(timestamp, max);

        int oldPrice = priceMap.getOrDefault(timestamp, -1);
        countMap.merge(oldPrice, -1, Integer::sum);
        if (countMap.get(oldPrice) == 0){
            countMap.remove(oldPrice);
        }

        countMap.merge(price, 1, Integer::sum);
        priceMap.put(timestamp, price);
    }

    public int current() {
        return priceMap.get(max);
    }

    public int maximum() {
        return countMap.lastKey();
    }

    public int minimum() {
        return countMap.ceilingKey(0);
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
