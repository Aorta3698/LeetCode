class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] gcd = new int[200001];
        for (int n : nums){
            for (int i = 1; i*i <= n; i++){
                if (n%i==0){
                    gcd[i]=gcd(gcd[i], n);
                    gcd[n/i]=gcd(gcd[n/i], n);
                }
            }
        }
        return (int)IntStream.range(1, 200001).filter(o -> gcd[o] == o).count();
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }
}


// class Solution {
//     public int countDifferentSubsequenceGCDs(int[] nums) {
//         List<Integer>[] all = new ArrayList[200001];
//         Arrays.setAll(all, o -> new ArrayList<>());
//         for (int j = 0; j < nums.length; j++){
//             for (int i = 1; i*i <= nums[j]; i++){
//                 if (nums[j]%i==0){
//                     all[i].add(j);
//                     if (i*i!=nums[j]){
//                         all[nums[j]/i].add(j);
//                     }
//                 }
//             }
//         }
//         int ans = 0;
//         for (int i = 1; i <= 200000; i++){
//             int cur = all[i].size()==0?0:nums[all[i].get(0)];
//             for (int n : all[i]){
//                 cur = gcd(cur, nums[n]);
//             }
//             if (cur == i){
//                 ans++;
//             }
//         }
//         return ans;
//     }

//     private int gcd(int a, int b){
//         return a == 0? b : gcd(b%a, a);
//     }
// }
