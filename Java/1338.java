https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/2443336/Java-or-Bucket-O(N)-or-With-Comments
class Solution {
    public int minSetSize(int[] arr) {
        int[] count = new int[100001];
        int[] bucket = new int[100001];
        for (int n : arr){
            count[n]++;
        }
        for (int n : count){
            bucket[n]++;
        }
        for (int i = 100000, del = 0, ans = 0; true; i--){
            ans += Math.min(bucket[i], (arr.length/2-del-1)/i+1);
            del += i * bucket[i];
            if (del >= arr.length/2){
                return ans;
            }
        }
    }
}
