class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        search(1, n+1, k, new LinkedList<>());

        return ans;
    }

    private void search(int start, int end, int num, LinkedList<Integer> l){
        if (start == end || l.size() == num){
            if (l.size() == num)
                ans.add(new ArrayList<>(l));
            return;
        }else{
            search(start+1, end, num, l);
            l.add(start);
            search(start+1, end, num, l);
            l.removeLast();
        }
    }
}
