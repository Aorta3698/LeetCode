https://leetcode.com/problems/number-of-atoms/discuss/2243388/Java-or-5ms-or-Parsing-backwards-or-O(nlogn)
class Solution {
    public String countOfAtoms(String A) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder nsb= new StringBuilder();
        stack.push(new HashMap<>());
        long num = 0;
        for (int i = A.length()-1;i>=0;--i){
            if (A.charAt(i)==')'){
                stack.push(new HashMap<>());
                numStack.push(getnum(nsb));
                nsb.setLength(0);
            }else if (A.charAt(i)=='('){
                Map<String, Integer> top = stack.pop();
                int mul = numStack.pop();
                for (String key : top.keySet()){
                    stack.peek().merge(key, top.get(key)*mul, Integer::sum);
                }
            }else if (Character.isDigit(A.charAt(i))){
                nsb.append(A.charAt(i));
            }else if (Character.isLowerCase(A.charAt(i))){
                sb.append(A.charAt(i));
            }else{ // upper case
                sb.append(A.charAt(i));
                stack.peek().merge(sb.reverse().toString(),getnum(nsb),Integer::sum);
                nsb.setLength(0);
                sb.setLength(0);
            }
        }

        Map<String, Integer> res = stack.pop();
        List<String> atoms = new ArrayList<>(res.keySet());
        Collections.sort(atoms);
        for (String key : atoms){
            sb.append(key);
            if (res.get(key)>1){
                sb.append(res.get(key));
            }
        }
        return sb.toString();
    }

    private int getnum(StringBuilder sb){
        return sb.isEmpty()?1:Integer.parseInt(sb.reverse().toString());
    }
}
