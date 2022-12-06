class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        keys.add(0);
        stack.push(0);

        while(!stack.isEmpty()){
            for (int i : rooms.get(stack.pop())){
                if (keys.add(i)) stack.push(i);
            }
        }

        return keys.size() == rooms.size();
    }
}
