class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> hi = new ArrayList<>();
        List<Integer> lo = new ArrayList<>();
        for (int c : colsum){
            int h = 0, l = 0;
            switch(c){
                case 2 -> h = l = 1;
                case 1 -> {
                    if (upper > lower)
                        h = 1;
                    else
                        l = 1;
                }
            }

            lower -= l;
            upper -= h;
            if (lower < 0 || upper < 0)
                return ans;
            hi.add(h);
            lo.add(l);
        }
        if (lower + upper > 0)
            return ans;
        ans.add(hi);
        ans.add(lo);
        return ans;
    }
}
