class Solution {
    public String solution(String polynomial) {
        String[] split = polynomial.split(" \\+ ");
        int coefficient = 0;
        int constant = 0;
        for (int i = 0 ; i < split.length ; i++) {
            if (split[i].contains("x")) {
               coefficient += getCoefficient(split[i]);
            } else {
                constant += Integer.parseInt(split[i]);
            }
        }
        return getPolyString(coefficient, constant);
    }
    
    public int getCoefficient(String s) {
        int number = 0;
        for (int j = 0 ; j < s.length() ; j++) {
            Character ch = s.charAt(j);
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            }
        }
        return number == 0 ? 1 : number;
    }
    
    public String getPolyString(int coefficient, int constant) {
        String poly = "";
        if (coefficient == 1) {
            poly = "x";
        } else if (coefficient == 0) {
            poly = "";
        } else {
            poly = String.format("%dx", coefficient);
        }
        if (constant == 0) {
            return poly;
        } else {
            return String.format(poly.isBlank() ? "%d" : poly + " + %d", constant);
        }
    }
}