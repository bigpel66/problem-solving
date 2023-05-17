class Solution {
    
    static public int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        boolean[] isVisited = new boolean[words.length];
        dfs(begin, target, words, isVisited, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] isVisited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(count, answer);
        }
        for (int i = 0; i < words.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            int diffCount = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diffCount++;
                }
            }
            if (diffCount == 1) {
                isVisited[i] = true;
                dfs(words[i], target, words, isVisited, count + 1);
                isVisited[i] = false;
            }
        }
    }
}