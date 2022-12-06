class MyCalendarTwo {

    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.merge(start, 1, Integer::sum);
        map.merge(end, -1, Integer::sum);
        int count = 0;
        for (int v : map.values()){
            count += v;
            if (count >= 3){
                if (map.merge(start, -1, Integer::sum) == 0){
                    map.remove(start);
                }
                if (map.merge(end, 1, Integer::sum) == 0){
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
