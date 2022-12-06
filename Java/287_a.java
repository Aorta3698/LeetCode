class Solution {
    public int convertTime(String current, String correct) {
        int[] option = new int[]{1, 5, 15, 60};
        int d = get(correct) - get(current), ans = 0;
        while(d > 0){
            ans++;
            for (int i = 3; i >= 0; i--){
                if (option[i] <= d){
                    d -= option[i];
                    break;
                }
            }
        }
        
        return ans;
    }

    private int get(String t){
        return 60 * Integer.parseInt(t.substring(0, 2)) + Integer.parseInt(t.substring(3));
    }
}
