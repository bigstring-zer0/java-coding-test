package 자료구조_활용;

import java.util.Stack;

public class 겹쳐진_압축_해제 {
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!c.equals(')')) stack.push(String.valueOf(c));
            else {
                String tmp1 = "";
                while (!stack.isEmpty()) {
                    String tmp2 = stack.pop();
                    if (tmp2.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res = "";
                        int cnt = 0;
                        if (num.equals("")) {
                            cnt = 1;
                        } else {
                            cnt = Integer.parseInt(num);
                        }
                        for (int i = 0; i < cnt; i++) {
                            res += tmp1;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp1 = tmp2 + tmp1;
                }
            }
        }
        for (String str : stack) {
            answer += str;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
