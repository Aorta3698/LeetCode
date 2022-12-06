class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int st = getTime(loginTime);
        int end = getTime(logoutTime);
        if (end < st){
            end += 60 * 24;
        }
        st += (15 - st % 15) % 15;
        end -= end % 15;
        return Math.max((end - st) / 15, 0);
    }

    private int getTime(String s){
        return 60 * Integer.parseInt(s.substring(0, 2)) + Integer.parseInt(s.substring(3));
    }
}
