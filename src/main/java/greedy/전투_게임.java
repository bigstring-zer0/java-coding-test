package greedy;

import java.util.*;

class Info implements Comparable<Info>{
    public int idx;
    public Character team;
    public int power;

    Info(int idx, Character team, int power){
        this.idx = idx;
        this.team = team;
        this.power = power;
    }

    @Override
    public int compareTo(Info ob){
        return this.power - ob.power;
    }
}

class Solution {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> infoList = new ArrayList<>();

        for(int idx = 0; idx < n; idx++){
            Character team = students[idx].split(" ")[0].charAt(0);
            int power = Integer.parseInt(students[idx].split(" ")[1]);
            infoList.add(new Info(idx, team, power));
        }

        Collections.sort(infoList);

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int j = 0, total = 0;

        for(int i = 1; i < n; i++){
            for( ; j < n; j++){
                if(infoList.get(j).power < infoList.get(i).power){
                    total += infoList.get(j).power;
                    char team = infoList.get(j).team;
                    hashMap.put(team, hashMap.getOrDefault(team, 0) + infoList.get(j).power);
                }
                else {
                    break;
                }
            }
            answer[infoList.get(i).idx] = total - hashMap.getOrDefault(infoList.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}