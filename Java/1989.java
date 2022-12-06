class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < team.length; i++){
            if (team[i] == 0){
                set.add(i);
            }
        }
        int sz = set.size();
        for (int i = 0; i< team.length; i++){
            if (team[i] == 1){
                Integer c = set.ceiling(i - dist);
                if (c == null)
                    break;
                if (c <= i + dist){
                    set.remove(c);
                }
            }
        }
        return sz - set.size();
    }
}
