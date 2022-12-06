class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        int a = toBeRemoved[0], b = toBeRemoved[1];
        for (int[] i : intervals){
            int st = i[0];
            int end = i[1];
            if (st >= a && end <= b){
                continue;
            }else if (end <= b && end > a){
                ans.add(List.of(st, a));
            }else if (st >= a && st < b){
                ans.add(List.of(b, end));
            }else if (st < a && end > b){
                ans.add(List.of(st, a));
                ans.add(List.of(b, end));
            }else{
                ans.add(List.of(st, end));
            }
        }

        return ans;
    }
}
