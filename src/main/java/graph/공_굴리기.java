package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 공_굴리기 {

    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length;
        int m = board[0].length;

        int[][] answer = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(answer[i], Integer.MAX_VALUE);
        answer[s[0]][s[1]] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        priorityQueue.add(new int[]{s[0], s[1], 0});

        while(!priorityQueue.isEmpty()) {
            int[] now = priorityQueue.poll();
            if(now[2] > answer[now[0]][now[1]]) continue;

            for(int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}){
                int nx = now[0];
                int ny = now[1];
                int len = now[2];

                while(nx>= 0 && nx < n&& ny >= 0 && ny < m && board[nx][ny] == 0){
                    nx += direction[0];
                    ny += direction[1];
                    len ++;
                }
                nx -= direction[0];
                ny -= direction[1];
                len --;

                if(answer[nx][ny] > len){
                    answer[nx][ny] = len;
                    priorityQueue.add(new int[]{nx, ny, len});
                }
            }
        }

        if(answer[e[0]][e[1]] == Integer.MAX_VALUE) return -1;

        else return answer[e[0]][e[1]];
    }

    public static void main(String[] args){
        공_굴리기 T = new 공_굴리기();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
