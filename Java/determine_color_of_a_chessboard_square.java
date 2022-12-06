class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(1) - '1' + coordinates.charAt(0) - 'a') % 2 == 1;
    }
}
