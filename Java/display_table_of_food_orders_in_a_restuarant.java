https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/discuss/1634827/Java-or-20-Lines-or-TreeMap-or-I-thought-food-length-less-20
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, int[]> table = new TreeMap<>();
        Map<String, Integer> foodtoID = new TreeMap<>();

        for (List<String> o : orders){
            int curTable = Integer.parseInt(o.get(1));
            String curFood = o.get(2);
            if(!foodtoID.containsKey(curFood)) foodtoID.put(curFood, foodtoID.size());
            table.computeIfAbsent(curTable, w -> new int[501])[foodtoID.get(curFood)]++;
        }

        List<String> header = new ArrayList<>(List.of("Table"));
        header.addAll(foodtoID.keySet());
        ans.add(header);

        for (int curTable : table.keySet()){
            List<String> cur = new ArrayList<>(List.of("" + curTable));
            for (String food : foodtoID.keySet()) cur.add("" + table.get(curTable)[foodtoID.get(food)]);
            ans.add(cur);
        }

        return ans;
    }
}
