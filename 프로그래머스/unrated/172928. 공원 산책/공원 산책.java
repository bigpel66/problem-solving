class Solution {    
    public int curX = -1;
    
    public int curY = -1;
    
    public int[] solution(String[] park, String[] routes) {
        getCurXAndCurY(park);
        for (int i = 0 ; i < routes.length ; i++) {
            char op = routes[i].charAt(0);
            int n = Character.getNumericValue(routes[i].charAt(2));
            switch (op) {
                case 'E':
                    move(park, 0, 1, n);
                    break;
                case 'W':
                    move(park, 0, -1, n);
                    break;
                case 'S':
                    move(park, 1, 0, n);
                    break;
                case 'N':
                    move(park, -1, 0, n);
            }
            System.out.println(curX + " " + curY);
        }
        return new int[]{curX, curY};
    }
    
    public void getCurXAndCurY(String[] park) {
        for (int i = 0 ; i < park.length ; i++) {
            for (int j = 0 ; j < park[i].length() ; j++) {
                if (park[i].charAt(j) == 'S') {
                    curX = i;
                    curY = j;
                    return;
                }
            }
        }
    }
    
    public void move(String[] park, int dx, int dy, int n) {
        int nextX = curX;
        int nextY = curY;
        for (int i = 0 ; i < n ; i++) {
            nextX += dx;
            nextY += dy;
            if (nextX < 0 || nextX >= park.length || nextY < 0 || nextY >= park[0].length()) {
                return;
            }
            if (park[nextX].charAt(nextY) == 'X') {
                return;
            }
        }
        curX = nextX;
        curY = nextY;
    }
}