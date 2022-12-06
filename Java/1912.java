class MovieRentingSystem {

    Map<Integer, Integer>[] map;
    Movie[] movies;
    TreeSet<List<Integer>> rented;
    public MovieRentingSystem(int n, int[][] entries) {
        map = new HashMap[n];
        movies=new Movie[10001];
        Arrays.setAll(map, o -> new HashMap<>());
        Arrays.setAll(movies, o->new Movie(o));
        rented=new TreeSet<>(Comparator.<List<Integer>>comparingInt(o -> map[o.get(0)].get(o.get(1)))
                                       .thenComparingInt(o -> o.get(0))
                                       .thenComparingInt(o -> o.get(1)));
        for (int[] e : entries){
            map[e[0]].put(e[1], e[2]);
            movies[e[1]].shops.add(e[0]);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> shops = movies[movie].shops;
        for (int i = 0; i < Math.min(5, shops.size()); i++){
            ans.add(i==0?shops.first():shops.higher(ans.get(ans.size()-1)));
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        rented.add(List.of(shop, movie));
        movies[movie].shops.remove(shop);
    }

    public void drop(int shop, int movie) {
        rented.remove(List.of(shop, movie));
        movies[movie].shops.add(shop);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(5, rented.size()); i++){
            ans.add(i==0?rented.first():rented.higher(ans.get(ans.size()-1)));
        }
        return ans;
    }

    private class Movie {
        int id;
        TreeSet<Integer> shops = new TreeSet<>(Comparator.<Integer>comparingInt(o -> map[o].get(id))
                                                         .thenComparingInt(o -> o));
        Movie(int id){
            this.id=id;
        }
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
