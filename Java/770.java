class Solution {
    Deque<Poly> stack = new ArrayDeque<>();
    Deque<String> op = new ArrayDeque<>();
    int[] order = new int[128];
    String ALL = ".";
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        order['*'] = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++){
            map.put(evalvars[i], evalints[i]);
        }
        String[] A = expression.replaceAll("\\(", "( ").replaceAll("\\)", " )").split(" ");
        for (int i = 0; i < A.length; i++) if (map.containsKey(A[i])){
            A[i] = ""+map.get(A[i]);
        }
        // System.out.println(Arrays.toString(A));
        return solve(A).build();
    }

    private Poly solve(String[] A){
        for (String s : A){
            switch(s){
                case "(" -> op.push(s);
                case ")" -> {go(ALL); op.pop();}
                case "+", "-", "*" -> {go(s); op.push(s);}
                default -> stack.push(new Poly(s));
            };
        }
        go(ALL);
        return stack.pop();
    }

    private void go(String s){
        int ch = s.charAt(0);
        while(!op.isEmpty() && order[op.peek().charAt(0)] >= order[ch] && !op.peek().equals("(")){
            Poly r = stack.pop(), l = stack.pop();
            switch(op.pop()){
                case "+" -> stack.push(l.add(r));
                case "-" -> stack.push(l.minus(r));
                default  -> stack.push(l.multiply(r));
            };
        }
    }

    private class Poly {
        List<Term> all = new ArrayList<>();

        Poly(List<Term> terms){
            all=terms;
        }

        Poly(String s){
            if (s.charAt(0) == '-' || s.chars().allMatch(Character::isDigit)){
                all.add(new Term(Integer.parseInt(s)));
            }else{
                all.add(new Term(s));
            }
        }

        Poly multiply(Poly other){
            Map<Term, Integer> map = new HashMap<>();
            for (Term a : all){
                for (Term b : other.all){
                    Term cur = new Term();
                    cur.rank = a.rank + b.rank;
                    cur.constant = a.constant * b.constant;
                    cur.variables.addAll(a.variables);
                    cur.variables.addAll(b.variables);
                    map.merge(cur, cur.constant, Integer::sum);
                }
            }
            return make(map);
        }

        Poly minus(Poly other){
            for (Term t : other.all){
                t.constant *= -1;
            }
            return add(other);
        }

        Poly add(Poly other){
            List<Term> cur = new ArrayList<>();
            Map<Term, Integer> map = new HashMap<>();
            for (Term t : all){
                map.merge(t, t.constant, Integer::sum);
            }
            for (Term t : other.all){
                map.merge(t, t.constant, Integer::sum);
            }
            return make(map);
        }

        Poly make(Map<Term, Integer> map){
            List<Term> ans = new ArrayList<>();
            for (Term t : map.keySet()){
                if (map.get(t) != 0){
                    t.constant = map.get(t);
                    ans.add(t);
                }
            }
            return new Poly(ans);
        }

        List<String> build(){
            List<String> ans = new ArrayList<>();
            var cmp = Comparator.<Term>comparingInt(o -> -o.rank).thenComparing(o -> o.all());
            all.sort(cmp);
            for (Term t : all){
                String got = t.serialize();
                if (!got.equals("0")){
                    ans.add(got);
                }
            }
            return ans;
        }
    }

    private class Term {
        int rank = 0;
        int constant = 1;
        List<String> variables = new ArrayList<>();

        Term(){}

        Term(int num){
            constant = num;
        }

        Term(String v){
            variables.add(v);
            rank = 1;
        }

        String all(){
            Collections.sort(variables);
            StringBuilder sb = new StringBuilder();
            for (String s : variables){
                sb.append('*');
                sb.append(s);
            }
            return sb.toString();
        }

        String serialize(){
            return constant + all();
        }

        @Override
        public boolean equals(Object o){
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Term other = (Term) o;
            return other.rank == rank &&
                   other.all().equals(all());
        }

        @Override
        public int hashCode(){
            return Objects.hash(all(), rank);
        }
    }
}
