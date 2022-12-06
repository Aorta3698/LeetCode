class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));
        int i = 0, j = 0;
        while(i < slots1.length && j < slots2.length && ans.isEmpty()){
            int a = slots1[i][0], b = slots1[i][1];
            int x = slots2[j][0], y = slots2[j][1];
            if (Math.max(a, x) + duration <= Math.min(b, y)){
                ans.add(Math.max(a, x));
                ans.add(ans.get(0) + duration);
            }else if (a > y || y - x < duration || y < b){
                ++j;
            }else{
                ++i;
            }
        }
        return ans;
    }
}
