import java.util.Arrays;

public class 비밀번호 {
    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int n = password.length();
        String[] psw = password.split("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[(i * 3) + j];
            }
        }
        for (int i = 1; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }

        int nx = 0, ny = 0;
        for (int i = 0; i < 10; i++) dist[i][i] = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n-1; i++) {
            answer += dist[Integer.parseInt(psw[i])][Integer.parseInt(psw[i + 1])];
        }
        return answer;
    }
    public static void main (String[]args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
