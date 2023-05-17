class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int count = 0;
        int index = 0;
        while (index < dartResult.length()) {
            if (!isSection(dartResult.charAt(index)) && !isOption(dartResult.charAt(index))) {
                score[count] = score[count] * 10 + dartResult.charAt(index++) - '0';
                continue;
            }
            if (isSection(dartResult.charAt(index))) {
                score[count] = processSection(dartResult.charAt(index++), score[count]);
            }
            if (index < dartResult.length() && isOption(dartResult.charAt(index))) {
                char option = dartResult.charAt(index++);
                if (option == '*') {
                    score[count] *= 2;
                    if (count - 1 >= 0) {
                        score[count - 1] *= 2;
                    }
                } else {
                    score[count] *= -1;
                }
            }
            count++;
        }
        return score[0] + score[1] + score[2];
    }

    boolean isSection(char ch) {
        return ch == 'S' || ch == 'D' || ch == 'T';
    }

    boolean isOption(char ch) {
        return ch == '*' || ch == '#';
    }

    int processSection(char ch, int val) {
        switch (ch) {
            case 'S':
                return val;
            case 'D':
                return val * val;
            case 'T':
                return val * val * val;
        }
        return 0;
    }
}