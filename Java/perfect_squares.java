class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
         if (map.containsKey(n)) return map.get(n);
         int sq = (int)Math.sqrt(n);
         if (sq*sq == n) return 1;
         int count = Integer.MAX_VALUE;

         for (int i = 0; i < sq; i++)
             count = Math.min(count,
                     numSquares((int)Math.pow(sq-i,2))+numSquares(n-(int)Math.pow(sq-i,2)));

         map.put(n, count);

         return count;
    }
}
