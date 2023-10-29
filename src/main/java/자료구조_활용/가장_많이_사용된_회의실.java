package 자료구조_활용;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class 가장_많이_사용된_회의실 {
    public int solution(int n, int[][] meetings) {
        int[] res = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        for (int[] meeting : meetings) {
            while (!pq.isEmpty() && pq.peek()[0] <= meeting[0]) rooms.add(pq.poll()[1]);
            if (!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                res[room]++;
                pq.add(new int[]{meeting[1], room});
            } else {
                int[] meet = pq.poll();
                res[meet[1]]++;
                pq.add(new int[]{meet[0] + (meeting[1] - meeting[0]), meet[1]});
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (res[answer] < res[i]) {
                answer = i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        가장_많이_사용된_회의실 T = new 가장_많이_사용된_회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
