class SmallestInfiniteSet {

    TreeSet<Integer> set;
    Set<Integer> used;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        used = new HashSet<>();
        set.add(1);
    }

    public int popSmallest() {
        int ans = set.pollFirst();
        if (set.isEmpty()){
            set.add(ans+1);
        }
        used.add(ans);
        return ans;
    }

    public void addBack(int num) {
        if (used.remove(num)){
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
