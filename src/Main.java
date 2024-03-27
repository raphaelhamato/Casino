import java.util.Scanner;

// Välkommen till Scam onlinecasinot!
// Skriv ditt namn:
// Hej namn!
// Välj vad du vill göra genom att fylla i ett nummer:
//      1. Spela Wheel of Fortune
//            Välkommen till Wheel of fortune! Ditt saldo är:
//            Hur mycket vill du satsa?
//            Startar spelet och snurrar hjulet.
//            Du vann x kr.
//            Du förlorade. (Tillbaks till huvudmenyn)
//
//      2. Spela Roulette
//            Välkommen till Roulette! Ditt saldo är:
//            Hur mycket vill du satsa?
//            Vill du satsa på rött eller svart?
//            Startar spelet och snurrar hjulet.
//            Du vann x kr.
//            Du förlorade. (Tillbaks till huvudmenyn)
//      3. Avsluta

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean running = true;
        WheelOfFortune wheelOfFortune = new WheelOfFortune();
        Roulette roulette = new Roulette();

        while (running) {
            System.out.println("Välkommen till Scam onlinecasino, vi tar dina pengar!");

            System.out.println("Skriv ditt namn");
            player.setNamn(scanner.nextLine());
            System.out.println("Hur mycket pengar vill du sätta in?");
            player.setSaldo(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Hej " + player.getNamn() + "!");

            boolean menuRunning = true;

            while (menuRunning) {
                System.out.println("Välj vad du vill göra genom att fylla i ett nummer:");
                System.out.println("1. Spela Wheel of Fortune");
                System.out.println("2. Spela Roulette");
                System.out.println("3. Avsluta");

                int val = scanner.nextInt();
                scanner.nextLine();

                switch (val) {
                    case 1:
                        wheelOfFortune.playGame(player, scanner);
                        break;
                    case 2:
                        roulette.playGame(player, scanner);
                        break;
                    case 3:
                        menuRunning = false;
                        break;
                    default:
                        System.out.println("Ogiltigt val. Vänligen välj igen.");
                        break;
                }
            }
            System.out.println("Hej då, tack för dina pengar!");
            running = false;
        }
    }
}