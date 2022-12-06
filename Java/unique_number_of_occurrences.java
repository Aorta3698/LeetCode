https://leetcode.com/problems/unique-number-of-occurrences/discuss/1633793/Java-or-One-Count-Array-Solution-or-Comments
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2002];
        for (int n : arr) ++count[n+1001];
        for (int i = 0; i < count.length; i++){
            if (count[i] == 0) continue;
            if (arr[count[i] - 1] == Integer.MIN_VALUE) return false;
            arr[count[i] - 1] = Integer.MIN_VALUE;
        }
        return true;
    }
}
