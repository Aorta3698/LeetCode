class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        List<String> ans = new ArrayList<>();
        Map<String, Map<Integer, Set<String>>> map = new HashMap<>();
        A[] arr = new A[n];
        for (int i = 0; i < n; i++){
            String[] tmp = transactions[i].split(",");
            arr[i] = new A(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), tmp[3]);
            map.computeIfAbsent(arr[i].name, o -> new HashMap<>())
               .computeIfAbsent(arr[i].time, o -> new HashSet<>())
               .add(arr[i].city);
        }

        for (int i = 0; i < n; i++){
            if (arr[i].cost > 1000){
                ans.add(transactions[i]);
                continue;
            }
            Map<Integer, Set<String>> timeMap = map.get(arr[i].name);
            for (int j = arr[i].time - 60; j <= arr[i].time + 60; j++){
                Set<String> cities = timeMap.get(j);
                if (cities == null) continue;
                if (cities.size() == 1 && cities.contains(arr[i].city)) continue;
                ans.add(transactions[i]);
                break;
            }
        }

        return ans;
    }

    private class A{
        String name;
        String city;
        int time;
        int cost;
        A(String name, int time, int cost, String city){
            this.name = name;
            this.time = time;
            this.cost = cost;
            this.city = city;
        }
    }
}
