import java.util.*;

class Solution {    
    public class Point {
        public int x;
        
        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
        
        public int getDiff(Point p) {
            return (int) Math.ceil(Math.sqrt((Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2))));
        }
        
        public String toString() {
            return String.format("(x, y) -> " + x + ", " + y);
        }
    }
    
    public Map<Integer, Point> ptrMap = new HashMap<>() {{
        put(1, new Point(0, 0));
        put(2, new Point(0, 1));
        put(3, new Point(0, 2));
        put(4, new Point(1, 0));
        put(5, new Point(1, 1));
        put(6, new Point(1, 2));
        put(7, new Point(2, 0));
        put(8, new Point(2, 1));
        put(9, new Point(2, 2));
        put(0, new Point(3, 1));
    }};
    
    public Point left = new Point(3, 0);
    
    public Point right = new Point(3, 2);
    
    public StringBuilder sequence = new StringBuilder();
    
    public String solution(int[] numbers, String hand) {
        for (int i = 0 ; i < numbers.length ; i++) {
            if (isLeft(numbers[i])) {
                updateLeft(numbers[i]);
            } else if (isRight(numbers[i])) {
                updateRight(numbers[i]);
            } else {
                updateLeftOrRight(numbers[i], hand);
            }
        }
        return sequence.toString();
    }
    
    public boolean isLeft(int value) {
        return value == 1 || value == 4 || value == 7;
    }
    
    public boolean isRight(int value) {
        return value == 3 || value == 6 || value == 9;
    }
    
    public void updateLeft(int value) {
        left = new Point(ptrMap.get(value));
        sequence.append("L");
    }
    
    public void updateRight(int value) {
        right = new Point(ptrMap.get(value));
        sequence.append("R");
    }
    
    public void updateLeftOrRight(int value, String hand) {
        Point current = ptrMap.get(value);
        int leftDiff = left.getDiff(current);
        int rightDiff = right.getDiff(current);
        if (leftDiff < rightDiff) {
            updateLeft(value);
        } else if (rightDiff < leftDiff) {
            updateRight(value);
        } else {
            if (hand.equals("left")) {
                updateLeft(value);
            } else {
                updateRight(value);
            }
        }
    }
}