class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int cur = 0;
        for (int i = 1; i < s.length() - 2; i++){
            for (String f : gen(s, 1, i)){
                for (String b : gen(s, i + 1, s.length() - 2)){
                    ans.add("(" + f + ", " + b + ")");
                }
            }
        }

        return ans;
    }

    List<String> gen(String s, int start, int end){
        List<String> ans = new ArrayList<>();
        for (int j = start; j < end; j++){
            String left = s.substring(start, j + 1);
            String right= s.substring(j + 1, end + 1);
            if (!right.endsWith("0") && (j - start == 0 || !left.startsWith("0"))){
                ans.add(left + "." + right);
            }
        }
        if (end - start == 0 || s.charAt(start) != '0'){
            ans.add(s.substring(start, end + 1));
        }

        return ans;
    }
}
