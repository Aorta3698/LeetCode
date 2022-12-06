/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int lo = -1, hi = fonts.length - 1;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            int width = 0, height = 0;
            for (char ch : text.toCharArray()){
                width += fontInfo.getWidth(fonts[mid], ch);
            }
            height = fontInfo.getHeight(fonts[mid]);

            if (height <= h && width <= w){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }

        return lo == -1? -1 : fonts[lo];
    }
}
