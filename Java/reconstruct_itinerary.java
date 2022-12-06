class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<Map.Entry<String, String>, Integer> ticketCount = new HashMap<>();

        for (List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            ticketCount.merge(Map.entry(from, to), 1, Integer::sum);

            List<String> des = map.getOrDefault(from, new ArrayList<>());
            des.add(to);
            map.put(from, des);
        }

        for (List<String> des : map.values())
            Collections.sort(des);

        path(map, tickets.size(), ticketCount, "JFK", new LinkedList<>(), ans);
        return ans;
    }

    private boolean path(HashMap<String, List<String>> map, int numOfTickets,
            HashMap<Map.Entry<String, String>, Integer> ticketCount,
            String start, LinkedList<String> path, List<String> ans){

        path.add(start);
        if (path.size() == numOfTickets + 1){
            ans.addAll(new ArrayList<>(path));

            return true;
        }

        if (!map.containsKey(start)) return false;

        for (String des : map.get(start)){
            if (ticketCount.get(Map.entry(start, des)) == 0)
                continue;

            ticketCount.merge(Map.entry(start, des), -1, Integer::sum);

            if (path(map, numOfTickets, ticketCount, des, path, ans))
                return true;

            ticketCount.merge(Map.entry(start, des), 1, Integer::sum);
            path.removeLast();
        }

        return false;
    }
}
