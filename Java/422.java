class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        char[][] mat = new char[n][n];
        for (int i = 0; i < words.size(); i++){
            String cur = words.get(i);
            if (cur.length() > n) return false;
            for (int j = 0; j < cur.length(); j++)
                mat[i][j] = cur.charAt(j);
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (mat[i][j] != mat[j][i])
                    return false;

        return true;
    }
}
