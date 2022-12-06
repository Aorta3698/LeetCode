class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        for (int i = 0, j = 0, m = 1; i < ages.length; i++){
            while (i < ages.length - 1 && ages[i] == ages[i + 1]){
                m++;
                i++;
            }
            while(j < i && ages[j] <= 0.5 * ages[i] + 7) {
                j++;
            }
            ans += (i - j) * m;
            m = 1;
        }

        return ans;
    }
}
