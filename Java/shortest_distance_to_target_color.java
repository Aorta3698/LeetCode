class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer>[] treeSets = new TreeSet[3];
        for (int i = 0; i < treeSets.length; i++) treeSets[i] = new TreeSet<Integer>();
        for (int i = 0; i < colors.length; i++) treeSets[colors[i] - 1].add(i);
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries){
            int c = q[1] - 1;
            if (c < 0 || c > 2 || treeSets[c].size() == 0) {ans.add(-1); continue;}
            TreeSet<Integer> set = treeSets[c];
            Integer top = set.ceiling(q[0]);
            Integer bot = set.floor(q[0]);
            if (top == null) ans.add(q[0] - bot);
            else if (bot == null) ans.add(top - q[0]);
            else ans.add(Math.min(q[0] - bot, top - q[0]));
        }

        return ans;
    }
}
