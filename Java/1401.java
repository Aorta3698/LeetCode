class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int i = yCenter - radius; i <= yCenter + radius; i++){
            for (int j = xCenter - radius; j <= xCenter + radius; j++){
                if (x1 <= j && x2 >= j && i >= y1 && i <= y2
                        && (i - yCenter) * (i - yCenter) + (j - xCenter) * (j - xCenter) <= radius * radius)
                    return true;
            }
        }
        return false;
    }
}
