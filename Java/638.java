class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] need = new int[needs.size()];
        for (int i = 0; i < needs.size(); i++){
            need[i] = needs.get(i);
        }

        return find(0, price, special, need,new HashMap<>());
    }

    private int find(int idx, List<Integer> price, List<List<Integer>> special, int[] needs, Map<String, Integer> memo){
        String key = idx+Arrays.toString(needs);
        if (memo.containsKey(key)){
            return memo.get(key);
        }

        int ans = 0;
        if (idx == special.size()){
            for (int i = 0; i < needs.length; i++){
                ans += price.get(i) * needs[i];
            }
            memo.put(key, ans);
            return ans;
        }

        ans = Integer.MAX_VALUE;
        List<Integer> cur = special.get(idx);
        boolean valid = true;

        for (int i = 0; valid; i++){
            for (int j = 0; j < needs.length; j++){
                needs[j] -= cur.get(j) * i;
                if (needs[j] < 0){
                    valid = false;
                }
            }
            if (valid){
                ans = Math.min(find(idx+1, price, special, needs, memo) + cur.get(price.size()) * i, ans);
            }
            for (int j = 0; j < needs.length; j++){
                needs[j] += cur.get(j) * i;
            }
        }

        memo.put(key, ans);
        return ans;
    }
}
