class Solution {
    private int ans = 0;
    public int numberOfPatterns(int m, int n) {
        if (m > n) return 0;
        find(m, n, new LinkedList<>(), new boolean[10]);
        return ans;
    }

    private void find(int lo, int hi, LinkedList<Integer> list, boolean[] seen){
        if (list.size() >= lo && list.size() <= hi) ans++;

        for (int i = 1; i <= 9; i++){
            if (seen[i] || !list.isEmpty() && !isValid(seen, list.getLast(), i)) continue;

            seen[i] = true;
            list.add(i);
            find(lo, hi, list, seen);
            seen[i] = false;
            list.removeLast();
        }
    }

    private boolean isValid(boolean[] seen, int prev, int cur){
        int cr = (cur - 1) / 3;
        int cc = (cur - 1) % 3;
        int pr = (prev - 1) / 3;
        int pc = (prev - 1) % 3;
        int dr = Math.abs(cr - pr);
        int dc = Math.abs(cc - pc);

        if (dr <= 1 && dc <= 1) return true;
        if (dc == dr) return seen[5];
        if (dr == 0) return seen[3 * pr + 1 + 1];
        if (dc == 0) return seen[3 + pc + 1];

        return true;
    }
}
