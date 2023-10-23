package 시뮬레이션_구현;

public class 과일_가져가기 {
    public int getMin(int[] fruit) {
        int min = 100;
        for (int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }

    public boolean isMinUnique(int[] fruit) {

        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if (x == min) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < fruit.length; i++) {
            if (min == fruit[i]) {
                return i;
            }
        }
        return 0;
    }

    public int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                continue;
            }
            if (!isMinUnique(fruit[i])) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (check[j] == 1) {
                    continue;
                }
                if (!isMinUnique(fruit[j])) {
                    continue;
                }
                int aFruit = getMinIndex(fruit[i]);
                int bFruit = getMinIndex(fruit[j]);
                if (aFruit != bFruit && fruit[i][bFruit] > 0 && fruit[j][aFruit] > 0) {
                    if (fruit[i][aFruit] + 1 <= fruit[i][bFruit] - 1 && fruit[j][bFruit] + 1 <= fruit[j][aFruit] - 1) {
                        fruit[i][aFruit]++;
                        fruit[i][bFruit]--;
                        fruit[j][bFruit]++;
                        fruit[j][aFruit]--;
                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }
                }

            }
        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }
    public static void main(String[] args) {
        과일_가져가기 T = new 과일_가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
