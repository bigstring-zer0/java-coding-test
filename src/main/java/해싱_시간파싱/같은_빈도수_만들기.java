package 해싱_시간파싱;

import java.util.Arrays;
import java.util.HashMap;

public class 같은_빈도수_만들기 {
    public int[] solution(String s) {
        int[] answer = new int[5];
        int maxVal = -100000;
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        HashMap<Character, Integer> strHash = new HashMap<>();

        for (char c : s.toCharArray()) {
            strHash.put(c, strHash.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            maxVal = Math.max(maxVal, strHash.get(c));
        }
        for (int i = 0; i < charArray.length; i++) {
            answer[i] = maxVal - strHash.getOrDefault(charArray[i], 0);
        }

        return answer;
    }
    public static void main(String[] args) {
        같은_빈도수_만들기 T = new 같은_빈도수_만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
