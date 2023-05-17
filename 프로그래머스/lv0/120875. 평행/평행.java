import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Integer> list = new ArrayList<>();
        list.add(crossProduct(dots[0], dots[1], dots[2], dots[3]));
        list.add(crossProduct(dots[0], dots[2], dots[1], dots[3]));
        list.add(crossProduct(dots[0], dots[3], dots[1], dots[2]));
        return list.contains(0) ? 1 : 0;
    }
    
    public int crossProduct(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int[] ab = new int[]{dot1[0] - dot2[0], dot1[1] - dot2[1]};
        int[] cd = new int[]{dot3[0] - dot4[0], dot3[1] - dot4[1]};
        return ab[0] * cd[1] - ab[1] * cd[0];
    }
}