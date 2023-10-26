package 해싱_시간파싱;

import 자료구조_활용.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 경고_메일 {
    public String[] solution(String[] reports, int time) {
        List<String> answerLst = new ArrayList<>();
        HashMap<String, Integer> statusHashMap = new HashMap<>();
        HashMap<String, Integer> useTimeHashMap = new HashMap<>();
        for (String report : reports) {
            String name = report.split(" ")[0];
            int min = Integer.parseInt(report.split(" ")[1].split(":")[0]) * 60 +
                    Integer.parseInt(report.split(" ")[1].split(":")[1]);
            String status = report.split(" ")[2];
            if (status.equals("in")) {
                statusHashMap.put(name, min);
            } else {
                useTimeHashMap.put(name, useTimeHashMap.getOrDefault(name, 0) + (min - statusHashMap.get(name)));
                statusHashMap.remove(name);
            }
        }
        for (String name : useTimeHashMap.keySet()) {
            if (useTimeHashMap.get(name) > time) {
                answerLst.add(name);
            }
        }
        answerLst.sort(String::compareTo);
        String[] answer = new String[answerLst.size()];
        for (int i = 0; i < answerLst.size(); i++) {
            answer[i] = answerLst.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        경고_메일 T = new 경고_메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
