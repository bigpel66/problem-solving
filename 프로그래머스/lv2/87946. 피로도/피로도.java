class Solution {
    
    static private final boolean[] isVisited = new boolean[8];

    static private int cases = Integer.MIN_VALUE;

    static public int solution(int k, int[][] dungeons) {
        dfs(0, k, dungeons);
        return cases;
    }

    static public void dfs(int count, int stress, int[][] dungeons) {
        cases = cases < count ? count : cases;
        for (int i = 0; i < dungeons.length; i++) {
            if (stress >= dungeons[i][0] && !isVisited[i]) {
                isVisited[i] = true;
                dfs(count + 1, stress - dungeons[i][1], dungeons);
                isVisited[i] = false;
            }
        }
    }

}