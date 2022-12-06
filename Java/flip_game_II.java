class Solution {
    HashMap<String, Boolean> seen = new HashMap<>();
    public boolean canWin(String currentState) {
        if (seen.containsKey(currentState))
            return seen.get(currentState);

        for (int i = 0; i < currentState.length(); i++){
            if (currentState.startsWith("++", i)){
                StringBuilder sb = new StringBuilder();
                sb.append(currentState.substring(0, i));
                sb.append("--");
                sb.append(currentState.substring(i + 2));
                String update = sb.toString();
                if (!canWin(update)){
                    seen.put(currentState, true);
                    return true;
                }
            }
        }

        seen.put(currentState, false);
        return false;
    }
}
