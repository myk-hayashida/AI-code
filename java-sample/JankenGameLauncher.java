import java.util.Scanner;

public class JankenGameLauncher {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            JankenGame game = new JankenGame(scanner);
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ゲームを終了します。");
    }
}
