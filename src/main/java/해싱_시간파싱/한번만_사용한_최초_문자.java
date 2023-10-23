package 해싱_시간파싱;

import java.util.HashMap;

public class 한번만_사용한_최초_문자 {
    public int solution(String s) {
        HashMap<Character, Integer> strHash = new HashMap<>();
        for (char c : s.toCharArray()) {
            strHash.put(c, strHash.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (strHash.get(s.charAt(i)) == 1) return i + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        한번만_사용한_최초_문자 T = new 한번만_사용한_최초_문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
