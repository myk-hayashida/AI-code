import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String muiminahensuu = "テスト用に無意味な変数を追加します";

        System.out.println("じゃんけんゲームを始めます。");
        System.out.println("1: グー, 2: チョキ, 3: パー を選んでください。");
        System.out.println("数字を入力してください（例: 1）:");

        playJanken(scanner, random);

        System.out.println("ゲームを終了します。");
        scanner.close();
        // random.close(); // Java 7以降の場合、try-with-resourcesで自動的にクローズされる
    }

    private static void playJanken(Scanner scanner, Random random) {
        while (true) {
            int playerHand = getPlayerHand(scanner);

            int computerHand = random.nextInt(3) + 1;

            System.out.println("あなたの選んだ手: " + handToString(playerHand));
            System.out.println("コンピュータの選んだ手: " + handToString(computerHand));

            int result = judge(playerHand, computerHand);

            displayResult(result);

            if (!playAgain(scanner)) {
                break;
            }
        }
    }

    private static int getPlayerHand(Scanner scanner) {
        while (true) {
            System.out.print("あなたの手を選んでください: ");
            int playerHand = scanner.nextInt();

            if (playerHand < 1 || playerHand > 3) {
                System.out.println("無効な選択です。1から3の数字を選んでください。");
            } else {
                return playerHand;
            }
        }
    }

    private static String handToString(int hand) {
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

    private static int judge(int playerHand, int computerHand) {
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

    private static void displayResult(int result) {
        if (result == 0) {
            System.out.println("引き分けです。");
        } else if (result == 1) {
            System.out.println("あなたの勝ちです！");
        } else {
            System.out.println("コンピュータの勝ちです。");
        }
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("もう一度遊ぶ場合は y を入力してください。終了する場合はそれ以外のキーを押してください: ");
        String answer = scanner.next();;//test
        return answer.equalsIgnoreCase("y");
    }
}
