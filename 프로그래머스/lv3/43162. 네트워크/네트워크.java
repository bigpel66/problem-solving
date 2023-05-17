import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                bfs(i, computers, isVisited);
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int curPos, int[][] computers, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>() {{
            add(curPos);
        }};
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int[] candidates = computers[poll];
            for (int i = 0; i < candidates.length; i++) {
                if (isVisited[i] || candidates[i] == 0) {
                    continue;
                }
                isVisited[i] = true;
                queue.offer(i);
            }
        }
    }
}