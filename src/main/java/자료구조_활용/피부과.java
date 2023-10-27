package 자료구조_활용;

import java.util.LinkedList;
import java.util.Queue;

public class 피부과 {
    public int transferTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 +
                Integer.parseInt(time.split(":")[1]);
    }

    public int solution(int[] laser, String[] enter) {
        int n = enter.length;
        int answer = 0;
        int[][] timeTable = new int[n][2];
        Queue<Integer> waitingQue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int time = transferTime(enter[i].split(" ")[0]);
            int laserNum = Integer.parseInt(enter[i].split(" ")[1]);
            timeTable[i][0] = time;
            timeTable[i][1] = laserNum;
        }
        waitingQue.offer(timeTable[0][1]);
        int finishTime = timeTable[0][0];
        int pos = 1;

        for (int time = finishTime; time <= 1200; time++) {
            if (pos < n && time == timeTable[pos][0]) {
                if (waitingQue.isEmpty() && timeTable[pos][0] > finishTime) {
                    finishTime = timeTable[pos][0];
                }
                waitingQue.offer(timeTable[pos][1]);
                pos++;
            }
            if (time == finishTime && !waitingQue.isEmpty()) {
                int idx = waitingQue.poll();
                finishTime += laser[idx];
            }
            answer = Math.max(answer, waitingQue.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
