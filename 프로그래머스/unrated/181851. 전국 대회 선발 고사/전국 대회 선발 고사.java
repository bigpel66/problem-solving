import java.util.*;
import java.util.stream.*;

class Solution {
    public class Player implements Comparable {
        public int number;
        
        public int rank;
        
        public boolean isAttendable;
        
        public Player(int number, int rank, boolean isAttendable) {
            this.number = number;
            this.rank = rank;
            this.isAttendable = isAttendable;
        }
        
        public int getNumber() {
            return number;
        }
        
        @Override
        public String toString() {
            return String.format("number: %d, rank: %d, isAttendable: %b\n", number, rank, isAttendable);
        }
        
        @Override
        public int compareTo(Object o) {
            Player p = (Player) o;
            if (isAttendable && !p.isAttendable) {
                return -1;
            } else if (!isAttendable && p.isAttendable) {
                return 1;
            } else {
                return Integer.compare(rank, p.rank);
            }   
        }
    }
    
    public int solution(int[] rank, boolean[] attendance) {
        List<Player> players = new ArrayList<>();
        for (int i = 0 ; i < rank.length ; i++) {
            players.add(new Player(i, rank[i], attendance[i]));
        }
        players.sort(Comparator.naturalOrder());
        return players.get(0).getNumber() * 10000 + players.get(1).getNumber() * 100 + players.get(2).getNumber();
    }
}