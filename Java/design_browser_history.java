https://leetcode.com/problems/design-browser-history/discuss/1632002/Java-or-One-List-Solution-or-Some-comments
class BrowserHistory {

    private List<String> cache;
    private int cur;
    private int max;
    public BrowserHistory(String homepage) {
        cache = new ArrayList<>(List.of(homepage));
    }

    public void visit(String url) {
        max = ++cur;
        if (cur < cache.size())
            cache.set(cur, url);
        else
            cache.add(url);
    }

    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return cache.get(cur);
    }

    public String forward(int steps) {
        cur = Math.min(max, cur + steps);
        return cache.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
