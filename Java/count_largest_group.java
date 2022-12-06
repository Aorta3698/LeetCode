class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        int max = 0;
        for (int i = 1; i <= n; i++){
            int sum = 0, copy = i;
            while(copy > 0){
                sum += copy % 10;
                copy /= 10;
            }
            max = Math.max(++count[sum], max);
        }

        int ans = 0;
        for (int c : count)
            if (c == max)
                ans++;

        return ans;
    }
}
