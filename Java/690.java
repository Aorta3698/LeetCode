/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> eMap = new HashMap<>();
        for (Employee e : employees) eMap.putIfAbsent(e.id, e);
        return dfs(eMap, id);
    }

    private int dfs(Map<Integer, Employee> map, int id){
        int sum = 0;
        for (int nextId : map.get(id).subordinates)
            sum += dfs(map, nextId);

        return sum + map.get(id).importance;
    }
}
