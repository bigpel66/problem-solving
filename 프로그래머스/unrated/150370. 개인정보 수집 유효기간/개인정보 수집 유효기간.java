import java.util.*;

class Solution {
    
    public class Privacy {
        public Integer index;
        
        public Integer number;
        
        public String term;
        
        public String collectedDate;
        
        public Integer collectedYear;
        
        public Integer collectedMonth;
        
        public Integer collectedDay;
        
        public Privacy(Integer index, String contents) {
            this.index = index;
            this.number = index + 1;
            String[] split = contents.split(" ");
            this.term = split[1];
            this.collectedDate = split[0];
            String[] date = split[0].split("\\.");
            this.collectedYear = Integer.parseInt(date[0]);
            this.collectedMonth = Integer.parseInt(date[1]);
            this.collectedDay = Integer.parseInt(date[2]);
        }
        
        public Integer getNumber() {
            return this.number;
        }
    }
    
    public Integer todayYear;
    
    public Integer todayMonth;
    
    public Integer todayDay;
    
    public Map<String, Integer> termsMap = new HashMap<>();
    
    public List<Privacy> privacyList = new ArrayList<>();
        
    public int[] solution(String today, String[] terms, String[] privacies) {
        setToday(today);
        generateTermsMap(terms);
        for (int i = 0 ; i < privacies.length ; i++) {
            privacyList.add(new Privacy(i, privacies[i]));
        }
        return privacyList.stream().filter(e -> isExpired(e)).mapToInt(e -> e.getNumber().intValue()).toArray();
    }
    
    public void setToday(String today) {
        String[] split = today.split("\\.");
        todayYear = Integer.parseInt(split[0]);
        todayMonth = Integer.parseInt(split[1]);
        todayDay = Integer.parseInt(split[2]);
    }
    
    public void generateTermsMap(String[] terms) {
        for (int i = 0 ; i < terms.length ; i++) {
            String[] split = terms[i].split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
    }
    
    public boolean isExpired(Privacy p) {
        int count = p.collectedYear * 12 * 28 + p.collectedMonth * 28 + p.collectedDay;
        count += termsMap.get(p.term) * 28;
        int limit = todayYear * 12 * 28 + todayMonth * 28 + todayDay;
        if (count <= limit) {
            return true;
        }
        return false;
    }
}