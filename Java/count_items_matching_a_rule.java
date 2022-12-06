class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int targetIdx = switch(ruleKey){
            case "type" : yield 0;
            case "color" : yield 1;
            case "name" : yield 2;
            default: yield -1;
        };

        int ans = 0;
        for (List<String> item : items){
            if (item.get(targetIdx).equals(ruleValue))
                ans++;
        }

        return ans;
    }
}
