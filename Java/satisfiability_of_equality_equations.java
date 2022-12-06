class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] groups = IntStream.range(0, 26).toArray();
        for (String s : equations)
            if (s.charAt(1) == '=')
                unite(groups, s.charAt(0)-'a', s.charAt(3)-'a');

        for (String s : equations)
            if (s.charAt(1) == '!')
                if(isConnected(groups, s.charAt(0)-'a', s.charAt(3)-'a'))
                    return false;

        return true;
    }

    private int find(int[] groups, int i){
        if (i != groups[i]) groups[i] = find(groups, groups[i]);
        return groups[i];
    }

    private void unite(int[] groups, int i, int j){
        i = find(groups, i);
        j = find(groups, j);
        groups[i] = j;
    }

    private boolean isConnected(int[] groups, int i, int j){
        i = find(groups, i);
        j = find(groups, j);
        return i == j;
    }
}
