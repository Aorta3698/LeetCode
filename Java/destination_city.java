class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> block = new HashSet<>();
        HashSet<String> dest = new HashSet<>();
        for (List<String> p : paths){
            block.add(p.get(0));
            dest.remove(p.get(0));
            if (!block.contains(p.get(1))) dest.add(p.get(1));
        }

        return dest.iterator().next();
    }
}
