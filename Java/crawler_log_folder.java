class Solution {
    public int minOperations(String[] logs) {
        int d = 0;
        for (String g : logs){
            if (!g.contains(".")) d++;
            if (g.contains("..")) d = Math.max(0, --d);
        }

        return d;
    }
}
