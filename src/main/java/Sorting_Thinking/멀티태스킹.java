package Sorting_Thinking;

import java.util.*;
class 멀티태스킹 {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int[] startTime = new int[tasks.length + 1];
        int rest = tasks.length;

        System.arraycopy(tasks, 0, startTime, 1, tasks.length);
        Arrays.sort(startTime);

        for(int i = 1; i < startTime.length; i++){
            long time = ((long)rest * (startTime[i] - startTime[i-1]));

            if(k < time){
                long idx = k % rest;
                int cnt = 0;

                for(int j = 0; j < tasks.length; j++){
                    if(tasks[j] >= startTime[i]){
                        if(cnt == idx) {
                            return j + 1;
                        }
                        cnt++;
                    }
                }
            }
            else{
                k -= time;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        멀티태스킹 T = new 멀티태스킹();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

