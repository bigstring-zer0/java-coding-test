package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 교육_과정 {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) node.put(subjects[i], i);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for(String str : course){
            int a = node.get(str.split(" ")[0]);
            int b = node.get(str.split(" ")[1]);
            graph.get(b).add(a);
            inDegree[a]++;
        }

        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);

            for(int x : graph.get(pre)){
                inDegree[x]--;

                if(inDegree[x] == 0){
                    queue.offer(x);
                }
            }
        }

        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = subjects[order.get(i)];
        }

        return answer;
    }

    public static void main(String[] args){
        교육_과정 T = new 교육_과정();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
