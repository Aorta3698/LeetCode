class Solution {
    public List<Integer> fallingSquares(int[][] A) {
        List<Integer> ans = new ArrayList<>();
        var map = new TreeMap<Integer, Integer>();
        map.put(0, 0);
        int max = 0;
        for (int[] a : A){
            int L = map.floorKey(a[0]), R = map.lowerKey(a[0]+a[1]);
            int now = map.subMap(L, true, R, true).values().stream().max(Comparator.naturalOrder()).get() + a[1];
            map.put(a[0]+a[1], map.floorEntry(a[0]+a[1]).getValue());
            map.subMap(a[0], a[0]+a[1]).clear();
            map.put(a[0], now);
            max = Math.max(now, max);
            ans.add(max);
        }
        return ans;
    }
}

// class Solution {
//     public List<Integer> fallingSquares(int[][] A) {
//         List<Integer> ans = new ArrayList<>();
//         var map = new TreeMap<Integer, int[]>();
//         int max = 0;
//         map.put(0, new int[]{(int)2e9, 0});
//         for (int[] a : A){
//             int cur = 0;
//             for (Integer x = 0; x != null && x < a[0]+a[1]; x = map.higherKey(x)){
//                 if (map.get(x)[0] > a[0]){
//                     cur = Math.max(cur, a[1] + map.get(x)[1]);
//                 }
//             }
//             map.put(a[0], new int[]{a[0]+a[1], cur});
//             max = Math.max(cur, max);
//             ans.add(max);
//         }

//         return ans;
//     }
// }
