package 자료구조_활용;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 현관문_출입_순서 {
    public int[] solution(int[] arrival, int[] state) {
        int n = arrival.length, prevState = 1;
        int[] answer = new int[n];
        Queue<Integer> enterQue = new LinkedList<>();
        Queue<Integer> exitQue = new LinkedList<>();

        for (int i = 0, time = 0, cnt = 0; ; time++) {
            if (enterQue.isEmpty() && exitQue.isEmpty() && i < n) {
                if (time < arrival[i]) {
                    time = arrival[i];
                    prevState = 1;
                }
            }
            while (i < n && arrival[i] <= time) {
                if (state[i] == 0) enterQue.offer(i);
                else exitQue.offer(i);
                i++;
            }
            if (prevState == 1) {
                if (!exitQue.isEmpty()) {
                    answer[exitQue.poll()] = time;
                    prevState = 1;
                } else {
                    answer[enterQue.poll()] = time;
                    prevState = 0;
                }
            } else if (prevState == 0) {
                if (!enterQue.isEmpty()) {
                    answer[enterQue.poll()] = time;
                    prevState = 0;
                } else {
                    answer[exitQue.poll()] = time;
                    prevState = 1;
                }
            }
            cnt++;
            if (cnt == n) break;
        }
        return answer;
    }
    public static void main(String[] args) {
        현관문_출입_순서 T = new 현관문_출입_순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
