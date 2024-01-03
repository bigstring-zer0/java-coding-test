package 넓이우선탐색_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 타일점프 {
    public int solution(int[] nums){
        int n = nums.length;
        int[] check = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        check[0] = 1;
        int L = 0;

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int x = queue.poll();

                for(int j = 1; j <= nums[x]; j++){
                    int nx = x + j;

                    if (nx == n - 1) {
                        return L + 1;
                    }
                    if(nx < n && check[nx] == 0){
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;

        }

        return -1;
    }

    public static void main(String[] args){
        타일점프 T = new 타일점프();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
