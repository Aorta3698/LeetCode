class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> ind = new HashMap<>();

        for (int i = 0; i < recipes.length; i++){
            for (String item : ingredients.get(i)){
                map.computeIfAbsent(item, o -> new ArrayList<>()).add(recipes[i]);
            }
            ind.merge(recipes[i], ingredients.get(i).size(), Integer::sum);
        }

        Queue<String> queue = new ArrayDeque<>();
        for (String s : supplies){
            queue.offer(s);
        }

        while(!queue.isEmpty()){
            for (String next : map.getOrDefault(queue.poll(), List.of())){
                if (ind.merge(next, -1, Integer::sum) == 0){
                    ans.add(next);
                    queue.offer(next);
                }
            }
        }

        return ans;
    }
}
