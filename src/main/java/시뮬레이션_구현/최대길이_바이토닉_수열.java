package 시뮬레이션_구현;

import java.util.ArrayList;

public class 최대길이_바이토닉_수열 {
    public int solution(int[] nums) {

        int answer = 0;

        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }
        for (int peak : peaks) {
            int left = peak;
            int right = peak;
            int cnt = 1;

            while (left - 1 >= 0 && nums[left] > nums[left - 1]) {
                left--;
                cnt++;
            }
            while (right + 1 < nums.length && nums[right] > nums[right + 1]) {
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args) {
        최대길이_바이토닉_수열 T = new 최대길이_바이토닉_수열();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
