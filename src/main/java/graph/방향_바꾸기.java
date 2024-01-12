package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 방향_바꾸기 {

    public int solution(int[][] board) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        priorityQueue.add(new int[]{0, 0, 0});

        int[][] answer = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(answer[i], Integer.MAX_VALUE);
        answer[0][0] = 0;

        while(!priorityQueue.isEmpty()) {
            int[] now = priorityQueue.poll();
            int direction = board[now[0]][now[1]] - 1;

            if(now[2] > answer[now[0]][now[1]]) continue;
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(k == direction && answer[nx][ny] > now[2]) {
                    answer[nx][ny] = now[2];
                    priorityQueue.offer(new int[]{nx, ny, now[2]});
                }
                else {
                    if (answer[nx][ny] > now[2] + 1) {
                        answer[nx][ny] = now[2] + 1;
                        priorityQueue.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
        }

        return answer[n - 1][m - 1];
    }

    public static void main(String[] args){
        방향_바꾸기 T = new 방향_바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
