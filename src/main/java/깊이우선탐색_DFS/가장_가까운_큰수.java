package 깊이우선탐색_DFS;

import java.util.ArrayList;

public class 가장_가까운_큰수 {

    int answer, target, m;
    ArrayList<Integer> nums;
    int[] check;
    boolean flag;

    public void DFS(int L, int number){
        if(flag) return;
        if(L == m){
            if(number > target){
                answer = number;
                flag = true;
            }
        }
        else{
            for(int i = 0; i < m; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    check[i] = 0;
                }
            }
        }
    }
    public int solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;

        while(tmp > 0){
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }

        nums.sort((a, b) -> a - b);
        m = nums.size();
        check = new int[m];
        DFS(0, 0);

        if(flag == false){
            return -1;
        }

        return answer;
    }

    public static void main(String[] args){
        가장_가까운_큰수 T = new 가장_가까운_큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
