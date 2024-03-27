import java.util.Random;
import java.util.Scanner;

public class Roulette {

    public Roulette(){

    }

    public void playGame(Player player, Scanner scanner) {
        System.out.println("Välkommen till Rouletten! Ditt saldo är: " + player.getSaldo());
        System.out.println("Hur mycket vill du satsa?");
        double rouletteBet = scanner.nextInt();
        scanner.nextLine();

        if (rouletteBet > player.getSaldo()) {
            System.out.println("Du har inte tillräckligt med pengar.");
        } else {
            String choice;
            boolean isValidChoice = false;

            while (!isValidChoice) {
                System.out.println("Vill du satsa på rött eller svart?");
                choice = scanner.nextLine().toLowerCase();
                if (choice.equals("rött") || choice.equals("svart")) {
                    isValidChoice = true;
                    bet(choice, rouletteBet, player);
                } else {
                    System.out.println("Ogiltig input. Vänligen välj mellan 'rött' eller 'svart'.");
                }
            }
        }
    }

    public void bet(String choice, double rouletteBet, Player player){
        Random random = new Random();
        int rouletteNumber = random.nextInt(3);
        player.setSaldo(player.getSaldo() - rouletteBet);

        if ((choice.equalsIgnoreCase("rött") && rouletteNumber == 1) ||
                (choice.equalsIgnoreCase("svart") && rouletteNumber == 2)) {
            System.out.println("Grattis du vann!");
            double vinst = rouletteBet * 2;
            player.setSaldo(player.getSaldo() + vinst);
        } else {
            System.out.println("Tyvärr, du förlorade.");
        }
    }
}