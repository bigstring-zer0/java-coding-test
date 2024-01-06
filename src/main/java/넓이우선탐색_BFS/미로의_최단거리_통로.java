package 넓이우선탐색_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의_최단거리_통로 {
    public int solution(int[][] board){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] distance = new int[7][7];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int L = 0;
        while(!queue.isEmpty()){
            L++;
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int[] now = queue.poll();

                for(int k = 0; k < 4; k++){
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        distance[nx][ny] = L;
                    }
                }
            }
        }

        if(distance[6][6]==0){
            return -1;
        }
        else{
            return distance[6][6];
        }
    }

    public static void main(String[] args){
        미로의_최단거리_통로 T = new 미로의_최단거리_통로();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
