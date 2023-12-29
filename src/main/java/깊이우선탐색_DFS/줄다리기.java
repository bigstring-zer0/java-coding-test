package 깊이우선탐색_DFS;

import java.util.Stack;

public class 줄다리기 {
    int[] check;
    int[][] relation;
    int answer;
    Stack<Integer> pm;

    public void DFS(int L){
        if(L == 7) {
            answer++;
        }
        else {
            for(int i = 1; i < 8; i++){
                if (!pm.empty() && relation[pm.peek()][i] == 1) {
                    continue;
                }
                if(check[i] == 0){
                    check[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    check[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];

        for(int[] x : fight){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }

        check = new int[8];
        DFS(0);

        return answer;
    }

    public static void main(String[] args){
        줄다리기 T = new 줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
