class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^A-Za-z0-9\\-\\_\\.]", "");
        while (true) {
            String s = new_id.replaceAll("\\.\\.", ".");
            if (!s.equals(new_id)) {
                new_id = s;
            } else {
                break;
            }
        }
        new_id = new_id.replaceAll("^\\.|\\.$","");
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        if (new_id.length() <= 2) {
            StringBuilder sb = new StringBuilder(new_id);
            Character ch = new_id.charAt(new_id.length() - 1);
            sb.append(ch.toString().repeat((3 - new_id.length())));
            new_id = sb.toString();
        }
        return new_id;
    }
}