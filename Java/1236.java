/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> ans = new HashSet<>(Set.of(startUrl));
        String hostname = getHostName(startUrl);
        Queue<String> queue = new ArrayDeque<>(List.of(startUrl));
        while(!queue.isEmpty())
            for (String html : htmlParser.getUrls(queue.poll()))
                if (html.startsWith(hostname) && ans.add(html))
                    queue.offer(html);

        return new ArrayList<>(ans);
    }

    private static String getHostName(String s){
        StringBuilder sb = new StringBuilder();
        int slash = 0;
        for (char ch : s.toCharArray()){
            if (ch == '/' && ++slash == 3) break;
            sb.append(ch);
        }

        return sb.toString();
    }
}
