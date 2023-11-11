import java.util.Scanner;

class CricketPlayer {
    String name;
    int innings, notout, totalruns;
    float bat_avg;

    public CricketPlayer(String name, int innings, int notout, int runs) {
        this.name = name;
        this.innings = innings;
        this.notout = notout;
        this.totalruns = runs;
        this.bat_avg = 0;
    }

    public static void avg(CricketPlayer[] players) {
        for (CricketPlayer player : players) {
                player.bat_avg = player.totalruns / (float) (player.innings - player.notout);
            
        }
    }

    public static void sort(CricketPlayer[] players) {
        for (int i = 0; i < players.length; i++) {
            for (int j = i + 1; j < players.length; j++) {
                if (players[i].bat_avg < players[j].bat_avg) {
                    CricketPlayer temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
    }

    public void display() {
        System.out.println("\nName: " + name);
        System.out.println("No of Innings: " + innings);
        System.out.println("No of Times Not Out: " + notout);
        System.out.println("Total Runs: " + totalruns);
        System.out.println("Batting Average: " + bat_avg);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of cricket players: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        CricketPlayer[] players = new CricketPlayer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for player " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("No of Innings: ");
            int innings = sc.nextInt();
            System.out.print("No of Times Not Out: ");
            int notout = sc.nextInt();
            System.out.print("Total Runs: ");
            int runs = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            players[i] = new CricketPlayer(name, innings, notout, runs);
        }
        CricketPlayer.avg(players);
        CricketPlayer.sort(players);

        for (CricketPlayer player : players) {
            player.display();
        }
        sc.close();
    }
}
