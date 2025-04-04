import java.util.Objects;

public class Player implements Comparable<Player> {
    private String name;
    private int points;
    private int UTR;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public Player(String name, int points, int UTR) {
        this.name = name;
        this.points = points;
        this.UTR = UTR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getUTR() {
        return UTR;
    }
    public void setUTR(int UTR) {
        this.UTR = UTR;
    }

    public void addTournamentPoints(String tournamentName) {
        int pointsToAdd = Tournament.getPoints(tournamentName);
        if (pointsToAdd > 0) {
            this.points += pointsToAdd;
            System.out.println(name + " earned " + pointsToAdd + " points from " + tournamentName);
        } else {
            System.out.println("Invalid tournament name: " + tournamentName);
        }
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.points, this.points); // Descending order
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points, UTR);
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', points=" + points + '}';
    }
}
