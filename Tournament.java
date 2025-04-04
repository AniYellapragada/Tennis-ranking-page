import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament {
    private static final Map<String, Integer> TOURNAMENT_POINTS = new HashMap<>();
    private final Map<String, List<Player>> participants = new HashMap<>();
    private static final double SEMIFINALIST_FRACTION = 0.5;
    private static final double QUARTERFINALIST_FRACTION = 0.25;

    static {
        // Grand Slams
        TOURNAMENT_POINTS.put("Australian Open", 2000);
        TOURNAMENT_POINTS.put("French Open", 2000);
        TOURNAMENT_POINTS.put("Wimbledon", 2000);
        TOURNAMENT_POINTS.put("US Open", 2000);

        // ATP Tournaments
        TOURNAMENT_POINTS.put("ATP Finals", 1500);
        TOURNAMENT_POINTS.put("ATP Masters 1000", 1000);
        TOURNAMENT_POINTS.put("ATP 500", 500);
        TOURNAMENT_POINTS.put("ATP 250", 250);
    }

    public static int getPoints(String tournamentName) {
        return TOURNAMENT_POINTS.getOrDefault(tournamentName, 0);
    }

    public static void listTournaments() {
        System.out.println("Available Tournaments and Points:");
        TOURNAMENT_POINTS.forEach((name, points) -> 
            System.out.println(name + ": " + points + " points")
        );
    }

    public void signUp(String tournamentName, Player player) {
        participants.computeIfAbsent(tournamentName, k -> new ArrayList<>()).add(player);
        System.out.println(player.getName() + " has signed up for " + tournamentName);
    }

    public List<Player> getParticipants(String tournamentName) {
        return participants.getOrDefault(tournamentName, Collections.emptyList());
    }

    public void awardPoints(String tournamentName, Player winner, List<Player> semifinalists, List<Player> quarterfinalists) {
        int winnerPoints = getPoints(tournamentName);
        int semifinalistPoints = (int) (winnerPoints * SEMIFINALIST_FRACTION);
        int quarterfinalistPoints = (int) (winnerPoints * QUARTERFINALIST_FRACTION);

        // Award points to the winner
        winner.addTournamentPoints(tournamentName);

        // Award points to semifinalists
        for (Player semifinalist : semifinalists) {
            semifinalist.setPoints(semifinalist.getPoints() + semifinalistPoints);
            System.out.println(semifinalist.getName() + " earned " + semifinalistPoints + " points as a semifinalist in " + tournamentName);
        }

        // Award points to quarterfinalists
        for (Player quarterfinalist : quarterfinalists) {
            quarterfinalist.setPoints(quarterfinalist.getPoints() + quarterfinalistPoints);
            System.out.println(quarterfinalist.getName() + " earned " + quarterfinalistPoints + " points as a quarterfinalist in " + tournamentName);
        }
    }
}
