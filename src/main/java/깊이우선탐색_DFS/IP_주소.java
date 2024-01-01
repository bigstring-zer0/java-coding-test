package 깊이우선탐색_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class IP_주소 {
    LinkedList<String> tmp;
    ArrayList<String> result;

    public void DFS(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String Ts = "";
            for(String x : tmp) {
                Ts += x + ".";
            }
            result.add(Ts.substring(0, Ts.length()-1));
        } else {
            for(int i = start; i < s.length(); i++){
                if(s.charAt(start) == '0' && i > start){
                    return;
                }
                String num = s.substring(start, i + 1);

                if (Integer.parseInt(num) > 255) {
                    return;
                }
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        result = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }

    public static void main(String[] args){
        IP_주소 T = new IP_주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
