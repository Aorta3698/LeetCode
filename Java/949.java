class Solution {
    public String largestTimeFromDigits(int[] arr) {
        return solve(0, arr, new boolean[4], new StringBuilder(), 0);
    }

    private String solve(int i, int[] arr, boolean[] seen, StringBuilder sb, int cur){
        if (i == 4)
            return cur < 60? sb.toString() : "";

        if (i == 2){
            if (cur >= 24)
                return "";
            sb.append(":");
            cur = 0;
        }

        int sz = sb.length();
        String ans = "";
        for (int j = 0; j < 4; j++){
            if (!seen[j]){
                seen[j] = true;
                sb.append(arr[j]);
                String res = solve(i + 1, arr, seen, sb, 10 * cur + arr[j]);
                if (time(res) > time(ans)){
                    ans = res;
                }
                sb.setLength(sz);
                seen[j] = false;
            }
        }
        return ans;
    }

    private int time(String s){
        if (s.isEmpty())
            return -1;
        return 60 * Integer.parseInt(s.substring(0, 2)) + Integer.parseInt(s.substring(3));
    }
}
