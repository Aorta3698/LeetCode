class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if (!expression.contains("*") && !expression.contains("-") && !expression.contains("+"))
            return new ArrayList<>(List.of(Integer.parseInt(expression)));

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if (ch == '*' || ch == '-' || ch == '+'){
                List<Integer> first = diffWaysToCompute(expression.substring(0, i));
                List<Integer> second = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (int f : first)
                    for (int s : second){
                        if (ch == '*') ans.add(f * s);
                        if (ch == '-') ans.add(f - s);
                        if (ch == '+') ans.add(f + s);
                    }
            }
        }

        return ans;
    }
}
