class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stud = new ArrayDeque<>();
        Deque<Integer> sand = new ArrayDeque<>();
        for (int s : students) stud.offer(s);
        for (int i = sandwiches.length - 1; i >= 0; i--) sand.push(sandwiches[i]);

        while(!sand.isEmpty()){
            int counter = stud.size();
            while(stud.peek() != sand.peek()) {
                stud.offer(stud.poll());
                if (--counter == 0) return stud.size();
            }

            stud.poll(); sand.pop();
        }

        return 0;
    }
}
