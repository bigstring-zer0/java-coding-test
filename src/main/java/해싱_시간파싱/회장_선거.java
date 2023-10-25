package 해싱_시간파싱;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 회장_선거 {
    public String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String vote : votes) {
            String recommender = vote.split(" ")[0];
            String referral = vote.split(" ")[1];
            voteHash.putIfAbsent(recommender, new HashSet<String>());
            voteHash.get(recommender).add(referral);
            candidate.put(referral, candidate.getOrDefault(referral, 0) + 1);
        }
        int maxVal = Integer.MIN_VALUE;

        for (String recommender : voteHash.keySet()) {
            int cnt = 0;
            for (String referral : voteHash.get(recommender)) {
                if (candidate.get(referral) >= k) {
                    cnt++;
                }
            }
            present.put(recommender, cnt);
            maxVal = Math.max(maxVal, cnt);
        }
        ArrayList<String> lst = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) == maxVal) {
                lst.add(name);
            }
        }
        Arrays.sort(lst.toArray());
        answer = lst.get(0);
        return answer;

    }
    public static void main(String[] args) {
        회장_선거 T = new 회장_선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}