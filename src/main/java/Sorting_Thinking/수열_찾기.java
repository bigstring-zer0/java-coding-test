package Sorting_Thinking;

import java.util.*;

public class 수열_찾기 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for(int x : nums) integerHashMap.put(x, integerHashMap.getOrDefault(x, 0) + 1);
        Arrays.sort(nums);
        int idx = 0;
        for(int x : nums){
            if(integerHashMap.get(x) == 0) continue;
            answer[idx] = x;
            idx++;
            integerHashMap.put(x, integerHashMap.get(x) - 1);
            integerHashMap.put(x*2, integerHashMap.get(x*2) - 1);
        }
        return answer;
    }

    public static void main(String[] args){
        수열_찾기 T = new 수열_찾기();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}