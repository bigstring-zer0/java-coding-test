package greedy;

import java.util.*;
class 이동_횟수 {
    public int solution(int[] nums){

        int answer = 0;
        int left = 0;
        int right = nums.length-1;

        Arrays.sort(nums);

        while(left <= right){
            if(nums[left] + nums[right] <= 5){
                answer++;
                left++;
                right--;
            } else{
                answer++;
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        이동_횟수 T = new 이동_횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
