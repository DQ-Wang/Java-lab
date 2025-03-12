import java.util.Scanner;
public class Main {
    private static final int[] PRIZE = {1, 2, 4, 8, 16, 32};
    private static final String[] PRIZE_NAMES = {"状元", "对堂", "三红", "四进", "二举", "一秀"};
    private static final int TOTAL_PRIZES = PRIZE.length;
    private static boolean[] prizeTaken = new boolean[TOTAL_PRIZES];
    private static int[] prize = PRIZE;

    public static int[] getAward() {
        int[] randomNum = new int[6];
        for (int i = 0; i < 6; i++) {
            randomNum[i] = 1 + (int) (Math.random() * 6); // 生成1到6之间的随机整数
        }
        printDice(randomNum);
        return randomNum;
    }

    public static String determineAward(int[] num) {
        int[] count = new int[7];
        for (int i : num) {
            count[i]++;
        }、
        if (count[1] == 6) return "遍地锦";
        else if (count[2] == 6 || count[3] == 6 || count[5] == 6 || count[6] == 6) return "六博黑";
        else if (count[4] == 6) return "六博红";
        else if (count[4] == 4 && count[1] == 2) return "状元插金花";
        else if (count[4] == 5) return "五王";
        else if (count[2] == 5 || count[3] == 5 || count[5] == 5 || count[6] == 5) return "五子";
        else if (count[4] == 4) return "四红";
        else if (count[1] == 1 && count[2] == 1 && count[3] == 1 && count[4] == 1 && count[5] == 1 && count[6] == 1) return "对堂";
        else if (count[4] == 3) return "三红";
        else if (count[1] == 4) {
            if (count[4] == 1) return "四进带一秀";
            else return "四进";
        } else if (count[4] == 2) return "二举";
        else if (count[4] == 1) return "一秀";
        else return "啥也不是";
    }

    public static int getPrizeIndex(String name) {
        for (int i = 0; i < TOTAL_PRIZES; i++) {
            if (name.equals(PRIZE_NAMES[i])) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean prizeIsTaken(int index, String name) {
        if (index == -1) {
            System.out.println("一无所获");
            return false;
        } else if (prize[index] > 0) {
            prize[index]--;
            System.out.println("获得：" + name);
            return true;
        } else if (prize[index] == 0) {
            prizeTaken[index] = true;
            System.out.println("奖品已领完");
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int player = 0;
        while (player < 6 || player > 10) {
            System.out.println("请输入玩家个数（6-10）:");
            if (s.hasNextInt()) {
                player = s.nextInt();
                if (player < 6 || player > 10) {
                    System.out.println("输入无效！玩家数必须在6到10之间，请重新输入。");
                }
            } else {
                System.out.println("输入无效，请输入（1-10）之间的整数");
                s.nextLine(); // 清除输入缓冲区
            }
        }
        System.out.println("player: " + player);
        int[][] playerAward = new int[player + 1][TOTAL_PRIZES];
        Boolean gameEnd = false;

        while (!gameEnd) {
            for (int i = 0; i < player; i++) {
                System.out.println("玩家" + (i + 1));
                int[] dice = getAward();
                String awardName = determineAward(dice);
                if (prizeIsTaken(getPrizeIndex(awardName), awardName)) {
                    playerAward[i + 1][getPrizeIndex(awardName)]++;
                }
            }
            gameEnd = checkGameEnd();
        }
        for(int i=0;i<player+1;i++){
            System.out.print("玩家1：");
         for(int j=0;j<TOTAL_PRIZES;j++){
             System.out.print(PRIZE_NAMES[playerAward[i][j]]+"*"+playerAward[i][j]+'\t');
         }
         System.out.println();
        }
    }

    private static void printDice(int[] dice) {
        System.out.print("投出的骰子点数：");
        for (int num : dice) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static Boolean checkGameEnd() {
        for (int p : prize) {
            if (p > 0) {
                return false;
            }
        }
        return true;
    }
}