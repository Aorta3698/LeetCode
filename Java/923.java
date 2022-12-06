class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int[] count = new int[101];
        for (int n : arr){
            count[n]++;
        }

        long ans = 0;
        for (int i = 0; i <= 100; i++){
            for (int lo = i, hi = 100; lo <= hi && count[i] > 0;){
                if (count[lo] == 0 || lo + hi < target - i){
                    lo++;
                    continue;
                }
                if (count[hi] == 0 || lo + hi > target - i){
                    hi--;
                    continue;
                }

                if (i != lo && lo != hi){
                    ans += 1L*count[i] * count[lo] * count[hi];
                }else if (i == lo && lo == hi){
                    ans += (1L*count[i] * (count[i] - 1) * (count[i] - 2)) / 6;
                }else if (i == lo){
                    ans += (1L*count[i] * (count[i] - 1) * count[hi]) / 2;
                }else{
                    ans += (1L*count[i] * (count[lo] - 1) * count[lo]) / 2;
                }
                hi--;
                lo++;
            }
        }

        return (int)(ans % (int)(1e9+7));
    }
}

// class Solution {
//     public int threeSumMulti(int[] arr, int target) {
//         int ans = 0, mod = (int)(1e9 + 7), n = arr.length;
//         Map<Integer, int[]> map = new HashMap<>();
//         for (int i = 0; i < arr.length; i++){
//             for (int key : map.keySet()){
//                 int[] count = map.get(key);
//                 count[i] = count[Math.max(i - 1, 0)];
//             }
//             map.computeIfAbsent(arr[i], o -> new int[n])[i]++;
//         }

//         for (int i = 0; i < n; i++){
//             for (int j = i + 1; j < n; j++){
//                 int[] pre = map.get(target - arr[i] - arr[j]);
//                 if (pre == null) continue;
//                 ans += pre[n - 1] - pre[j];
//                 ans %= mod;
//             }
//         }

//         return ans;
//     }
// }
