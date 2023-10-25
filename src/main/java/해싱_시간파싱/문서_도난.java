package 해싱_시간파싱;

import java.util.*;
import java.util.stream.Collectors;

public class 문서_도난 {
    public String[] solution(String[] reports, String times) {
        List<String> answerLst = new ArrayList<>();
        int startTime = Integer.parseInt(times.split(" ")[0].split(":")[0]) * 60 +
                Integer.parseInt(times.split(" ")[0].split(":")[1]);
        int endTime = Integer.parseInt(times.split(" ")[1].split(":")[0]) * 60 +
                Integer.parseInt(times.split(" ")[1].split(":")[1]);
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String report : reports) {
            String name = report.split(" ")[0];
            String time = report.split(" ")[1];
            int HH = Integer.parseInt(time.split(":")[0]);
            int MM = Integer.parseInt(time.split(":")[1]);
            hashMap.putIfAbsent(name, HH * 60 + MM);
        }

        List<Map.Entry<String, Integer>> entries =
                hashMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            if (startTime <= entry.getValue() && entry.getValue() <= endTime) {
                answerLst.add(entry.getKey());
            }
        }

        String[] answer = new String[answerLst.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerLst.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        문서_도난 T = new 문서_도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
