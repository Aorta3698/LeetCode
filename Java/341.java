/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList){
            dfs(n);
        }
    }

    private void dfs(NestedInteger cur){
        if (cur.isInteger()){
            queue.offer(cur.getInteger());
        }
        for (NestedInteger next : cur.getList()){
            dfs(next);
        }
    }

    @Override
    public Integer next() {
        if (hasNext()){
            return queue.poll();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
