class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length(), d = 'a' - 'A';
        int[] res = new int[3];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            boolean[] seen = new boolean[128];
            int pending = 0;
            for (int j = i; j < arr.length; j++){
                int cur = arr[j], comp = cur < 'a'? arr[j] + d : arr[j] - d;
                if (!seen[cur] && !seen[comp]) pending++;
                if (!seen[cur] && seen[comp]) pending--;
                if (pending == 0 && j - i > res[0]) res = new int[]{j - i, i, j};
                seen[cur] = true;
            }
        }

        return res[0] == 0? "" : s.substring(res[1], res[2] + 1);
    }
}
