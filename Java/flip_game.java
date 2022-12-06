class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < currentState.length()-1; i++){
            if (currentState.charAt(i) == '-' || currentState.charAt(i+1) == '-') continue;
            StringBuilder sb = new StringBuilder();
            sb.append(currentState.substring(0, i));
            sb.append("--");
            sb.append(currentState.substring(i+2, currentState.length()));
            ans.add(sb.toString());
        }

        return ans;
    }
}
