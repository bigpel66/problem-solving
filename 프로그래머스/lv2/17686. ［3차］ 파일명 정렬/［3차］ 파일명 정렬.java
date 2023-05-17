import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Solution {
    public class File implements Comparable {
        public String name;
        
        public int index;
        
        public String head;
        
        public int number;
        
        public File(String s, int index) {
            this.name = s;
            this.index = index;
            this.head = getHead(s);
            this.number = getNumber(s);
        }
        
        public String getHead(String s) {
            Matcher headMatcher = Pattern.compile("^[A-Za-z]+[A-Za-z\\s\\.\\-]+").matcher(s);
            headMatcher.find();
            return s.substring(headMatcher.start(), headMatcher.end()).toLowerCase();
        }
    
        public int getNumber(String s) {
            Matcher numberMatcher = Pattern.compile("[0-9]+").matcher(s);
            numberMatcher.find();
            return Integer.parseInt(s.substring(numberMatcher.start(), numberMatcher.end()));  
        }
        
        @Override
        public int compareTo(Object obj) {
            File o = (File) obj;
            if (head.equals(o.head) && number == o.number) {
                return Integer.compare(index, o.index);
            }
            if (head.equals(o.head) && number != o.number) {
                return Integer.compare(number, o.number);
            }
            return head.compareTo(o.head);
        }
        
        @Override
        public String toString() {
            return String.format("%s:%d with head (%s), number (%d)", name, index, head, number);
        }
    }
        
    public String[] solution(String[] files) {
        List<File> list = IntStream.range(0, files.length).mapToObj(i -> new File(files[i], i)).collect(Collectors.toList());
        return list.stream().sorted().map(e -> e.name).toArray(String[]::new);
    }
}