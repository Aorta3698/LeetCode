class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int pos = 0;
        int neg = 0;
        for (int s : satisfaction){
            if (s > 0) pos += s;
            else neg += s;
        }

        int count = 0;
        int ans = 0;
        for (int i = 0; i < satisfaction.length; i++){
            int w = satisfaction[i];
            if (w >= 0) ans += w * ++count;
            else{
                int take = (count + 1) * w + (neg - w) + pos;
                if (take > 0) ans += w * ++count;
                neg -= w;
            }
        }

        return ans;
    }
}
