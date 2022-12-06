class Solution {
    public int maxDistance(int[] colors) {
        int idx = 0;
        for (int i = 0; i < colors.length; i++)
            if (colors[i] != colors[colors.length - 1]){
                idx = colors.length - i - 1;
                break;
            }

        for (int i = colors.length - 1; i >= 0; --i){
            if (colors[i] != colors[0]){
                idx = Math.max(idx, i);
                break;
            }
        }

        return idx;
    }
}
