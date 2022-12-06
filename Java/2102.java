class SORTracker {

    Comparator<Place> cmp = Comparator.<Place>comparingInt(o -> -o.score).thenComparing(o -> o.name);
    TreeSet<Place> set = new TreeSet<>(cmp);
    Place cur = new Place("", 0);
    public SORTracker() {
        set.add(cur);
    }

    public void add(String name, int score) {
        Place place = new Place(name, score);
        set.add(place);
        if (cmp.compare(cur, place)>0){
            cur=set.lower(cur);
        }
    }

    public String get() {
        String ans = cur.name;
        cur=set.higher(cur);
        return ans;
    }

    private class Place {
        String name;
        int score;
        Place(String name, int score){
            this.name = name;
            this.score= score;
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
