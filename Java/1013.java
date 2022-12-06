class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        if (prefix[n] % 3 != 0) return false;
        boolean two = false;
        for (int i = n - 1, t = prefix[n] / 3; i > 0; i--){
            if (two && prefix[i] == t) return true;
            if (prefix[i] == t * 2) two = true;
        }

        return false;
    }
}
