import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player("Player 1", 5000, 12);
        Player player2 = new Player("Player 2", 4500, 11);
        Player player3 = new Player("Player 3", 4000, 10);
        Player player4 = new Player("Player 4", 3500, 9);

        // Create tournament and sign up players
        Tournament tournament = new Tournament();
        tournament.signUp("Wimbledon", player1);
        tournament.signUp("Wimbledon", player2);
        tournament.signUp("Wimbledon", player3);
        tournament.signUp("Wimbledon", player4);

        // Award points for Wimbledon
        tournament.awardPoints(
            "Wimbledon",
            player1, // Winner
            Arrays.asList(player2, player3), // Semifinalists
            Arrays.asList(player4) // Quarterfinalists
        );

        // Search for tournament results
        Search search = new Search();
        search.addTournamentResult(
            "Wimbledon",
            player1,
            Arrays.asList(player2, player3),
            Arrays.asList(player4)
        );

        System.out.println("\nSearch for Wimbledon results:");
        search.searchTournament("Wimbledon");

        System.out.println("\nSearch for Player 2's tournaments:");
        search.searchPlayer("Player 2");

        System.out.println("\nUpdated Rankings:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(player4);
    }
}
