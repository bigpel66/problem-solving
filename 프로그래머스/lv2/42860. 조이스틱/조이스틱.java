class Solution {
    public int solution(String name) {
        int answer = 0;
        int widthShift = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int aPosition = i + 1;
            while (aPosition < name.length() && name.charAt(aPosition) == 'A') {
                aPosition++;
            }
            // 처음부터 오른쪽으로만 가는 케이스 vs 특정 지점까지 오른쪽으로 갔다가 왼쪽으로 꺾는 케이스
            // 후자 케이스는 오른쪽으로 온 만큼 2번 겪고, 그 외 연속된 A를 제한 수만큼을 더함 (인덱스 i 기준으로 i * 2 + diff)
            widthShift = Math.min(widthShift, i * 2 + (name.length() - aPosition));
            // 위 케이스 결과 vs 특정 지점까지 왼쪽으로 갔다가 오른쪽으로 꺾는 케이스
            // 후자 케이스는 A를 제한 수만큼을 2번 겪고, 나머지 온 만큼을 더함 (인덱스 i 기준으로 diff * 2 + i)
            widthShift = Math.min(widthShift, i + (name.length() - aPosition) * 2);
        }
        return answer + widthShift;
    }
}