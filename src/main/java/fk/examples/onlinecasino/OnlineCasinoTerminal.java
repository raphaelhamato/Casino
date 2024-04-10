package fk.examples.onlinecasino;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import fk.examples.onlinecasino.model.Player;
import fk.examples.onlinecasino.model.Roulette;
import fk.examples.onlinecasino.model.WheelOfFortune;
import fk.examples.onlinecasino.json.GsonPlayerJSONExporter;
import fk.examples.onlinecasino.xml.JcabiPlayerXMLImporter;

public class OnlineCasinoTerminal {

	private Scanner scanner = new Scanner(System.in);

	private static WheelOfFortune WHEELOFFORTUNE = new WheelOfFortune();

	private static Roulette ROULETTE = new Roulette();

	public void start() throws FileNotFoundException {
		System.out.println("Välkommen till Online Casinot!");
		List<Player> players = JcabiPlayerXMLImporter.importPlayers("players.xml");

		Player player = valjSpelare(players);

		while (true) {
			System.out.println("Hej " + player.getFullName() + "! Ditt saldo är: " + player.getCredit());
			System.out.println("Välj ett spel:");
			System.out.println("1. Lyckohjulet");
			System.out.println("2. Roulette");
			System.out.println("0. Avsluta");

			System.out.print("Ditt val: ");
			int spelVal = scanner.nextInt();

			switch (spelVal) {
			case 1:
				spelaLyckohjulet(player);
				break;
			case 2:
				spelaRoulette(player);
				break;
			case 0:
				System.out.println("Tack för att du spelade. Välkommen åter!");
				GsonPlayerJSONExporter.exportPlayers(players, "players_exported.json");
				return;
			default:
				System.out.println("Ogiltigt val, försök igen.");
			}
		}
	}

	private Player valjSpelare(List<Player> players) {
		System.out.println("Välj en spelare:");
		for (int i = 0; i < players.size(); i++) {
			System.out.println((i + 1) + ". " + players.get(i).getFullName());
		}

		System.out.print("Ditt val: ");
		int val = scanner.nextInt();
		if (val < 1 || val > players.size()) {
			System.out.println("Ogiltigt val. Vänligen välj igen.");
			return valjSpelare(players);
		}

		return players.get(val - 1);
	}

	private void spelaLyckohjulet(Player player) {
		System.out.println("Välkommen till Lyckohjulet!");
		WHEELOFFORTUNE.spin(player, 100);
	}

	private void spelaRoulette(Player player) {
		System.out.println("Välkommen till Roulette!");
		System.out.println("What color do you play? 1. Red, 2. Black");

		boolean color = scanner.nextInt() == 1;
		ROULETTE.bet(player, 100, color);
	}

	public static void main(String[] args) throws FileNotFoundException {
		OnlineCasinoTerminal console = new OnlineCasinoTerminal();
		console.start();
	}
}