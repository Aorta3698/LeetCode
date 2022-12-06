class ExamRoom {

    LinkedList<Integer> all;
    int n;
    public ExamRoom(int n) {
        all = new LinkedList<>();
        this.n = n - 1;
    }

    public int seat() {
        if (all.isEmpty()){
            all.add(0);
            return 0;
        }
        int head = all.get(0), tail = n - all.getLast();
        int prev = 0, st = -1, end = -1, idx = 0, target = 0;
        for (int s : all){
            if ((s - prev)/2 > (end - st)/2){
                st = prev;
                end = s;
                target = idx;
            }
            prev = s;
            idx++;
        }
        if (head >= (end-st)/2 && head >= tail){
            all.add(0, 0);
            return 0;
        }
        if ((end-st)/2 >= tail){
            all.add(target, st + (end-st)/2);
            return st+(end-st)/2;
        }
        all.add(n);
        return n;
    }

    public void leave(int p) {
        all.remove((Integer)p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
