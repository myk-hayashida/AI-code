import java.util.Random;
import java.util.Scanner;

public class JankenGame {
    private Scanner scanner;
    private Random random;

    public JankenGame(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public void start() {
        System.out.println("じゃんけんゲームを始めます。");
        System.out.println("1: グー, 2: チョキ, 3: パー を選んでください。");
        System.out.println("数字を入力してください（例: 1）:");

        int numFlg = 9; 
        playJanken();
    }

    private void playJanken() {
        while (true) {
            int playerHand = getPlayerHand();

            int computerHand = random.nextInt(3) + 1;

            System.out.println("あなたの選んだ手: " + handToString(playerHand));
            System.out.println("コンピュータの選んだ手: " + handToString(computerHand));

            int result = judge(playerHand, computerHand);

            displayResult(result);

            if (!playAgain()) {
                break;
            }
        }
    }

    private int getPlayerHand() {
        while (true) {
            System.out.print("あなたの手を選んでください: ");
            try {
                int playerHand = scanner.nextInt();
                scanner.nextLine(); // 改行文字を捨てる
                if (playerHand < 1 || playerHand > 3) {
                    System.out.println("無効な選択です。1から3の数字を選んでください。");
                } else {
                    return playerHand;
                }
            } catch (Exception e) {
                System.out.println("無効な入力です。1から3の数字を入力してください。");
                scanner.nextLine(); // 改行文字を捨てる
            }
        }
    }

    private String handToString(int hand) {
        switch (hand) {
            case 1:
                return "グー";
            case 2:
                return "チョキ";
            case 3:
                return "パー";
            default:
                return "不明";
        }
    }

    private int judge(int playerHand, int computerHand) {
        if (playerHand == computerHand) {
            return 0; // 引き分け
        } else if ((playerHand == 1 && computerHand == 2) ||
                (playerHand == 2 && computerHand == 3) ||
                (playerHand == 3 && computerHand == 1)) {
            return 1; // プレイヤーの勝ち
        } else {
            return -1; // コンピュータの勝ち
        }
    }

    private void displayResult(int result) {
        if (result == 0) {
            System.out.println("引き分けです。");
        } else if (result == 1) {
            System.out.println("あなたの勝ちです！");
        } else {
            System.out.println("コンピュータの勝ちです。");
        }
    }

    private boolean playAgain() {
        System.out.print("もう一度遊ぶ場合は y を入力してください。終了する場合はエンターキーを押してください: ");
        String answer = scanner.nextLine().trim();
        return answer.equalsIgnoreCase("y");
    }
}
