class MyCalendar {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Integer l = map.floorKey(start);
        Integer r = map.lowerKey(end);
        if (l != null && map.get(l) > start || r != null && map.get(r) > start){
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
