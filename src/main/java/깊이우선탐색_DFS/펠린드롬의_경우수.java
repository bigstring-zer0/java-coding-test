package 깊이우선탐색_DFS;

import java.util.*;

public class 펠린드롬의_경우수 {
    Deque<Character> tmp;
    ArrayList<String> result;
    HashMap<Character, Integer> hashMap;
    int len;

    public void DFS(){
        if(tmp.size() == len){
            String tS = "";
            for(char x : tmp) tS += x;
            result.add(tS);
        } else{
            for(char key : hashMap.keySet()){
                if (hashMap.get(key) == 0) {
                    continue;
                }
                tmp.addFirst(key);
                tmp.addLast(key);
                hashMap.put(key, hashMap.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                hashMap.put(key, hashMap.get(key) + 2);
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        result = new ArrayList<>();
        hashMap = new HashMap<>();
        len = s.length();

        for(char x : s.toCharArray()){
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        int odd = 0;
        char mid = '#';

        for(char key : hashMap.keySet()){
            if(hashMap.get(key) % 2 == 1){
                mid = key;
                odd++;
            }
        }
        if(odd > 1){
            return new String[]{};
        }
        if(mid != '#'){
            tmp.add(mid);
            hashMap.put(mid, hashMap.get(mid) - 1);
        }
        DFS();

        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        펠린드롬의_경우수 T = new 펠린드롬의_경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
