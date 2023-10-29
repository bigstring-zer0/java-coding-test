package 자료구조_활용;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU_스케쥴링 {
    public int[] solution(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];

        LinkedList<int[]> schedule = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            schedule.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        schedule.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int finishTime = 0, idx = 0;
        while (!schedule.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                finishTime = Math.max(finishTime, schedule.peek()[0]);
            }
            while (!schedule.isEmpty() && schedule.peek()[0] <= finishTime) {
                int[] x = schedule.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] execute = pq.poll();
            finishTime += execute[0];
            answer[idx++] = execute[1];
        }
        return answer;
    }
    public static void main(String[] args) {
        CPU_스케쥴링 T = new CPU_스케쥴링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
