class Solution {
    public String minimizeResult(String expression) {
        int m = expression.indexOf("+");
        String a = expression.substring(0, m);
        String b = expression.substring(m + 1);
        List<Item> list = new ArrayList<>();

        for (int i = 0; i < a.length(); i++){
            for (int j = 1; j <= b.length(); j++){
                int first = i == 0? 1 : Integer.parseInt(a.substring(0, i));
                int second = Integer.parseInt(a.substring(i)) + Integer.parseInt(b.substring(0, j));
                int third = j == b.length()? 1 : Integer.parseInt(b.substring(j));
                list.add(new Item(first * second * third, i, j - 1));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.val));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++){
            if (i == list.get(0).left)
                sb.append('(');
            sb.append(a.charAt(i));
        }
        sb.append("+");
        for (int i = 0; i < b.length(); i++){
            sb.append(b.charAt(i));
            if (i == list.get(0).right)
                sb.append(')');
        }

        return sb.toString();
    }

    private class Item{
        int val;
        int left;
        int right;
        Item (int val, int left, int right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
