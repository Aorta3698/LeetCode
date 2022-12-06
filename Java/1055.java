class Solution {
    public int shortestWay(String source, String target) {
        int ans = 0;
        List<Integer>[] list = new ArrayList[26];
        Arrays.setAll(list, o -> new ArrayList<>());
        for (int i = 0; i < source.length(); i++){
            list[source.charAt(i) - 'a'].add(i);
        }

        for (int i = 0, j, min; i < target.length(); i = j, ans++){
            for (j = i, min = -1; j < target.length(); j++){
                List<Integer> cur = list[target.charAt(j) - 'a'];
                int lo = 0, hi = cur.size();

                while(lo < hi){
                    int mid = (lo + hi) >> 1;
                    if (cur.get(mid) > min){
                        hi = mid;
                    }else{
                        lo = mid + 1;
                    }
                }
                if (lo == cur.size()){
                    if (min == -1)
                        return -1;
                    break;
                }
                min = cur.get(lo);
            }
        }

        return ans;
    }
}
