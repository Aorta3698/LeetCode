class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return dfs(students, mentors, 0, new boolean[students.length]);
    }

    private int dfs(int[][] s, int[][] m, int cur, boolean[] seen){
        if (cur == s.length){
            return 0;
        }

        int max = 0;
        for (int j = 0; j < m.length; j++){
            if (seen[j]) continue;
            seen[j] = true;
            max = Math.max(dfs(s, m, cur + 1, seen) + score(m[j], s[cur]), max);
            seen[j] = false;
        }

        return max;
    }

    private int score(int[] a, int[] b){
        int s = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == b[i])
                s++;
        return s;
    }
}
