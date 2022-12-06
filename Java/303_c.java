class FoodRatings {

    Map<String, TreeSet<Food>> cui;
    Map<String, String> fc;
    Map<String, Integer> rating;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rating = new HashMap<>();
        fc = new HashMap<>();
        cui = new HashMap<>();
        for (int i = 0; i < foods.length; i++){
            Food cur = new Food(foods[i], ratings[i]);
            rating.put(foods[i], ratings[i]);
            fc.put(foods[i], cuisines[i]);
            cui.computeIfAbsent(cuisines[i], o -> new TreeSet<>((a, b) -> a.rating==b.rating?a.food.compareTo(b.food):b.rating-a.rating)).add(cur);
        }
    }

    public void changeRating(String food, int newRating) {
        Food prev = new Food(food, rating.get(food));
        cui.get(fc.get(food)).remove(prev);
        cui.get(fc.get(food)).add(new Food(food, newRating));
        rating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cui.get(cuisine).first().food;
    }

    private class Food{
        String food;
        int rating;
        Food (String food, int rating){
            this.food = food;
            this.rating = rating;
        }
    }
}
