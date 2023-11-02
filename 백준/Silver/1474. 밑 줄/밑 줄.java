import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Main {
    private final StringBuilder sb;
    private int numberOfWord, numberOfInterval, targetLength, wordLength;
    private int commonUnderScoreCount, leftOverUnderScoreCount;
    private StringBuilder[] words;

    public Main() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();
            getInput(br);
            solve();
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private void getInput(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfWord = Integer.parseInt(st.nextToken());
        numberOfInterval = numberOfWord - 1;
        targetLength = Integer.parseInt(st.nextToken());
        wordLength = 0;
        words = new StringBuilder[numberOfWord];
        for (int i = 0; i < numberOfWord; i++) {
            words[i] = new StringBuilder();
            words[i].append(br.readLine());
            wordLength += words[i].length();
        }
    }

    private void calcUnderScoreCount() {
        commonUnderScoreCount = (targetLength - wordLength) / numberOfInterval;
        leftOverUnderScoreCount = (targetLength - wordLength) % numberOfInterval;
    }

    private char firstCharacter(StringBuilder word) {
        return word.charAt(0);
    }

    private void fillUnderScore() {
        for (int i = 0; i < numberOfInterval; i++) {
            StringBuilder currWord = words[i];
            StringBuilder nextWord = words[i + 1];
            boolean isNextWordLowerCase = Character.isLowerCase(firstCharacter(nextWord));
            boolean isAppendableWhenNextWordUpperCase = numberOfInterval - leftOverUnderScoreCount <= i;
            if (leftOverUnderScoreCount > 0 && (isNextWordLowerCase || isAppendableWhenNextWordUpperCase)) {
                currWord.append("_");
                leftOverUnderScoreCount--;
            }
            currWord.append("_".repeat(commonUnderScoreCount));
        }
    }

    private void aggregateWords() {
        for (int i = 0; i < numberOfWord; i++) {
            sb.append(words[i].toString());
        }
    }

    private void solve() {
        calcUnderScoreCount();
        fillUnderScore();
        aggregateWords();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}