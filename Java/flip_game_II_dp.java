class Solution {
    public boolean canWin(String currentState) {
        for (int i = 0; i < currentState.length() - 1; i++){
            if (currentState.substring(i, i + 2).equals("++")){
                StringBuilder sb = new StringBuilder();
                sb.append(currentState.substring(0, i));
                sb.append("--");
                sb.append(currentState.substring(i + 2));
                String next = sb.toString();

                if (!canWin(next)){
                    return true;
                }
            }
        }

        return false;
    }
}
