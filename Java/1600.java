class ThroneInheritance {

    private Map<String, List<String>> parentMap;
    private String king;
    private Set<String> death;
    public ThroneInheritance(String kingName) {
        parentMap = new HashMap<>();
        king = kingName;
        death = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        parentMap.computeIfAbsent(parentName, o -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        Set<String> ans = new LinkedHashSet<>();
        if (!death.contains(king)) ans.add(king);
        dfs(king, ans);
        return new ArrayList<>(ans);
    }

    private void dfs(String cur, Set<String> ans){
        for (String kid : parentMap.getOrDefault(cur, Collections.emptyList()))
            if (death.contains(kid) || ans.add(kid))
                dfs(kid, ans);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
