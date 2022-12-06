class MyCalendarThree {

    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        if (map.merge(start, 1, Integer::sum) == 0){
            map.remove(start);
        }
        if (map.merge(end, -1, Integer::sum) == 0){
            map.remove(end);
        }

        int ans = 0, count = 0;
        for (int v : map.values()){
            count += v;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
