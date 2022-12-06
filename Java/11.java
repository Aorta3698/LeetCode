class Solution {
    public int maxArea(int[] height) {
        List<Integer> back = new ArrayList<>();
        List<Integer> front = new ArrayList<>();
        int n = height.length, ans = 0;

        for (int i = 0; i < n; i++){
            if (front.isEmpty() || height[i] > height[front.get(front.size() - 1)]){
                front.add(i);
            }
            if (back.isEmpty() || height[n - i - 1] > height[back.get(back.size() - 1)]){
                back.add(n - 1 - i);
            }
        }

        for (Integer x : front){
            for (Integer y : back){
                if (x >= y) break;
                ans = Math.max(ans, Math.min(height[x], height[y]) * (y - x));
            }
        }

        return ans;
    }
}
