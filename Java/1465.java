class Solution {
    public int maxArea(int h, int w, int[] H, int[] W) {
        Arrays.sort(H);
        Arrays.sort(W);
        long height = Math.max(H[0], h-H[H.length-1]);
        long width  = Math.max(W[0], w-W[W.length-1]);
        for (int i = 1; i < H.length; i++){
            height = Math.max(H[i]-H[i-1],height);
        }
        for (int i = 1; i < W.length; i++){
            width = Math.max(W[i]-W[i-1],width);
        }
        return (int)(height*width%(int)(1e9+7));
    }
}
