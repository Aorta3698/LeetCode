class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        // return h(n, new HashMap<>(Map.of(1,1,2,2,3,3)));
        
        int[] arr = new int[]{1, 2, 3};
        for (int i = 3; i < n; i++){
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[0] + arr[1];
        }

        return arr[2];
    }

    // private int h(int n, HashMap<Integer, Integer> map){
    //     if (map.containsKey(n))
    //         return map.get(n);

    //     map.put(n, h(n-1, map) + h(n-2, map));
    //     return map.get(n);
    // }
}
