package 넓이우선탐색_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 집을_짓자 {
    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int empty = 0;

        int[][] distance = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;
                    queue.offer(new int[]{i, j});

                    int L = 0;
                    while(!queue.isEmpty()){
                        L++;

                        int len = queue.size();
                        for(int r = 0; r < len; r++){
                            int[] now = queue.poll();

                            for(int k = 0; k < 4; k++){
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];

                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == empty){
                                    board[nx][ny]--;
                                    distance[nx][ny] += L;
                                    queue.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, distance[nx][ny]);
                                }
                            }
                        }
                    }
                    empty--;

                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        집을_짓자 T = new 집을_짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
