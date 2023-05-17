class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0 ; i < skill_trees.length ; i++) {
            if (isAchievable(skill, skill_trees[i])) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isAchievable(String skill, String order) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < order.length() ; i++) {
            if (skill.indexOf(order.charAt(i)) != -1) {
                sb.append(order.charAt(i));
            }
        }
        return skill.startsWith(sb.toString());
    }
}