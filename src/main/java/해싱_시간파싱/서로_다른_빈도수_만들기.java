package 해싱_시간파싱;

import java.util.HashMap;
import java.util.HashSet;

public class 서로_다른_빈도수_만들기 {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> charHash = new HashMap<>();
        HashSet<Integer> intSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charHash.put(c, charHash.getOrDefault(c, 0) + 1);
        }
        for (Character key : charHash.keySet()) {
            while (intSet.contains(charHash.get(key))) {
                answer++;
                charHash.put(key, charHash.get(key) - 1);
            }
            if (charHash.get(key) == 0) continue;
            intSet.add(charHash.get(key));
        }
        return answer;

    }
    public static void main(String[] args) {
        서로_다른_빈도수_만들기 T = new 서로_다른_빈도수_만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
