https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/discuss/1976580/Java-or-Concise-O(n)-or-99-Speed.
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int[] count = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            count[arr[i] > arr.length? arr.length : arr[i]]++;
        }

        int ans = 1;
        for (int i = 1; i < count.length; i++){
            ans = Math.min(i, ans + count[i]);
        }

        return ans;
    }
}

