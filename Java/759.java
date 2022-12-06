/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (List<Interval> s : schedule){
            for (Interval e : s){
                line.merge(e.start, 1, Integer::sum);
                line.merge(e.end, -1, Integer::sum);
            }
        }
        int cur = 0, start = -1;
        for (int key : line.keySet()){
            cur += line.get(key);
            if (cur > 0 && start > -1){
                ans.add(new Interval(start, key));
                start = -1;
            }
            if (cur == 0){
                start = key;
            }
        }
        return ans;
    }
}
