import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public double solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        double answer = 0;
        String strL1 = str1.toLowerCase();
        String strL2 = str2.toLowerCase();

        for (int i = 0; i < strL1.length() - 1; i++) {
            if (
                    Pattern.matches("^[a-z]", String.valueOf(strL1.charAt(i))) &&
                            Pattern.matches("^[a-z]", String.valueOf(strL1.charAt(i+1)))) {
                String s = strL1.substring(i, i + 2);
                list1.add(s);
            }
        }

        for (int i = 0; i < strL2.length() - 1; i++) {
            if (
                    Pattern.matches("^[a-z]", String.valueOf(strL2.charAt(i))) &&
                            Pattern.matches("^[a-z]", String.valueOf(strL2.charAt(i+1)))) {
                String s = strL2.substring(i, i + 2);
                list2.add(s);
            }
        }

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for(int i = 0; i < list1.size(); i++) {
            int count = 0;

            for(int j = 0; j < list1.size(); j++) {
                if(list1.get(i).equals(list1.get(j))) {
                    count++;
                }
            }
            m1.put(list1.get(i), count);
        }

        for(int i = 0; i < list2.size(); i++) {
            int count = 0;

            for(int j = 0; j < list2.size(); j++) {
                if(list2.get(i).equals(list2.get(j))) {
                    count++;
                }
            }
            m2.put(list2.get(i), count);
        }

        double intersection = 0;

        for (String key1 : m1.keySet()) {
            for(String key2: m2.keySet()) {
                if(key1.equals(key2)) {
                    intersection += Math.min(m1.get(key1), m2.get(key2));
                }
            }
        }

        double union = list1.size() + list2.size() - intersection;

        if (intersection == union) {
            answer = 65536;
        } else {
            answer = (intersection / union) * 65536;
        }

        return Math.floor(answer);
    }
}