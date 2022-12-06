class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] tot = new int[(int)Math.pow(3, toppingCosts.length)];
        generate(0, toppingCosts, 0, 0, tot);
        Arrays.sort(tot);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++){
            int lo = 0, hi = tot.length - 2;
            while(lo < hi){
                int mid = (hi + lo + 1) >> 1;
                if (tot[mid] + baseCosts[i] <= target){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }
            int a = tot[lo] + baseCosts[i];
            int b = tot[lo + 1] + baseCosts[i];
            int da = Math.abs(target - a);
            int db = Math.abs(target - b);
            int dc = Math.abs(ans - target);
            if (da < dc || da == dc && a < ans){
                ans = a;
            }
            dc = Math.abs(ans - target);
            if (db < dc  || db == dc && b < ans){
                ans = b;
            }
        }

        return ans;
    }

    private int generate(int i, int[] cost, int sum, int j, int[] tot){
        if (i == cost.length){
            tot[j] = sum;
            return ++j;
        }

        for (int m = 0; m <= 2; m++){
            j = generate(i + 1, cost, sum + cost[i] * m, j, tot);
        }

        return j;
    }
}
