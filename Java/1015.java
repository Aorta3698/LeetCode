class Solution {
    public int smallestRepunitDivByK(int k) {
        // int len = (int)Math.log10(k) + 1, num = Integer.parseInt("1".repeat(len));
        // if (num < k) {
        //     num = 10 * num + 1;
        //     len++;
        // }
        // int mod = num % k;
        int mod = 1 % k, len = 1;
        Set<Integer> seen = new HashSet<>();
        while(seen.add(mod) && mod != 0){
            mod = (10 * mod + 1) % k;
            len++;
        }

        return mod == 0? len : -1;
    }
}
