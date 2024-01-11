package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 벽_허물기 {

    public int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] answer = new int[n][m];

        for(int i = 0; i < n; i++) Arrays.fill(answer[i], Integer.MAX_VALUE);
        answer[0][0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        priorityQueue.add(new int[]{0, 0, 0});

        while(!priorityQueue.isEmpty()) {
            int[] now = priorityQueue.poll();
            if(now[2] > answer[now[0]][now[1]]) continue;

            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(board[nx][ny] == 0 && answer[nx][ny] > now[2]) {
                    answer[nx][ny] = now[2];
                    priorityQueue.offer(new int[]{nx, ny, now[2]});
                }
                else if(board[nx][ny] == 1 && answer[nx][ny] > now[2] + 1){
                    answer[nx][ny] = now[2] + 1;
                    priorityQueue.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return answer[n - 1][m - 1];
    }

    public static void main(String[] args){
        벽_허물기 T = new 벽_허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
