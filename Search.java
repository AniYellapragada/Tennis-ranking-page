import java.util.*;

public class Search {
    private final Map<String, TournamentResult> tournamentResults = new HashMap<>();

    public void addTournamentResult(String tournamentName, Player winner, List<Player> semifinalists, List<Player> quarterfinalists) {
        tournamentResults.put(tournamentName, new TournamentResult(winner, semifinalists, quarterfinalists));
    }

    public void searchTournament(String tournamentName) {
        TournamentResult result = tournamentResults.get(tournamentName);
        if (result != null) {
            System.out.println("Tournament: " + tournamentName);
            System.out.println("Winner: " + result.getWinner().getName());
            System.out.println("Semifinalists: " + result.getSemifinalists());
            System.out.println("Quarterfinalists: " + result.getQuarterfinalists());
        } else {
            System.out.println("No results found for tournament: " + tournamentName);
        }
    }

    public void searchPlayer(String playerName) {
        boolean found = false;
        System.out.println("Tournaments played by " + playerName + ":");
        for (Map.Entry<String, TournamentResult> entry : tournamentResults.entrySet()) {
            String tournamentName = entry.getKey();
            TournamentResult result = entry.getValue();
            if (result.getWinner().getName().equals(playerName)) {
                System.out.println(tournamentName + " (Winner)");
                found = true;
            } else if (result.getSemifinalists().stream().anyMatch(p -> p.getName().equals(playerName))) {
                System.out.println(tournamentName + " (Semifinalist)");
                found = true;
            } else if (result.getQuarterfinalists().stream().anyMatch(p -> p.getName().equals(playerName))) {
                System.out.println(tournamentName + " (Quarterfinalist)");
                found = true;
            }
        }
        if (!found) {
            System.out.println(playerName + " has not participated in any tournaments.");
        }
    }

    private static class TournamentResult {
        private final Player winner;
        private final List<Player> semifinalists;
        private final List<Player> quarterfinalists;

        public TournamentResult(Player winner, List<Player> semifinalists, List<Player> quarterfinalists) {
            this.winner = winner;
            this.semifinalists = new ArrayList<>(semifinalists);
            this.quarterfinalists = new ArrayList<>(quarterfinalists);
        }

        public Player getWinner() {
            return winner;
        }

        public List<Player> getSemifinalists() {
            return semifinalists;
        }

        public List<Player> getQuarterfinalists() {
            return quarterfinalists;
        }
    }
}
