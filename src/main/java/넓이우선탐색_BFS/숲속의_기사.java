package 넓이우선탐색_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 숲속의_기사 {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    int L = 0;
                    int[][] check = new int[n][m];

                    check[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        L++;
                        int len = queue.size();

                        for(int r = 0; r < len; r++){
                            int[] cur = queue.poll();

                            for(int k = 0; k < 4; k++){
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];

                                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1){
                                    if(check[nx][ny] == 0){
                                        check[nx][ny] = 1;
                                        distance[nx][ny] += L;
                                        queue.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 4 && distance[i][j] > 0){
                    answer = Math.min(answer, distance[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        숲속의_기사 T = new 숲속의_기사();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
