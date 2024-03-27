import java.util.Random;
import java.util.Scanner;

public class WheelOfFortune {
    public int spin(){
        Random random = new Random();
        return random.nextInt(30) + 1;
    }

    public void playGame(Player player, Scanner scanner) {
        System.out.println("Välkommen till Wheel of Fortune! Ditt saldo är: " + player.getSaldo());
        System.out.println("Hur mycket vill du satsa?");
        int fortuneBet = scanner.nextInt();
        scanner.nextLine();

        if (fortuneBet > player.getSaldo()) {
            System.out.println("Du har inte tillräckligt med pengar.");
        } else {
            player.setSaldo(player.getSaldo() - fortuneBet);
            System.out.println("Startar spelet och snurrar hjulet.");
            int spinResult = spin();
            if (spinResult < 5) {
                double vinst = fortuneBet * 2;
                System.out.println("Grattis, du vann " + vinst / 2 + " kr!");
                player.setSaldo(player.getSaldo() + vinst);
            } else if (spinResult <= 15) {
                double vinst = fortuneBet * 1.5;
                System.out.println("Grattis, du vann " + vinst / 3 + " kr!");
                player.setSaldo(player.getSaldo() + vinst);
            } else {
                System.out.println("Tyvärr, ingen vinst denna gång.");
            }
        }
    }
}