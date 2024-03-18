import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    /*
    I'll determine a random num using a lib, and provide a method to start the game and call
    the player methods and attach each try. Then, it prints out the winner(s)
    */
    private ArrayList<Player> playerList;
    private int playerAmount;
    private int randomNumber;
    public void start() {
        setRandomNumber();
        int localRandomNumber = getRandomNumber();
        System.out.println(localRandomNumber);

        setPlayerAmount();
        int localPlayerAmount = getPlayerAmount();
        setPlayerList(localPlayerAmount);

        ArrayList<Player> localPlayerList = getPlayerList();
        defineWinners(localRandomNumber, localPlayerList);
        sendWinners(localPlayerList);
    }

    public void setPlayerAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        this.playerAmount = Integer.parseInt(scanner.nextLine());
    }

    public int getPlayerAmount() {
        return this.playerAmount;
    }

    public void setPlayerList(int amount) {
        this.playerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            this.playerList.add(new Player());
        }
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public void setRandomNumber() {
        Random random = new Random();
        this.randomNumber = random.nextInt(100);
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }

    public void defineWinners(int random, ArrayList<Player> list) {
        for (Player player : list) {
            player.guess();
            if (player.getNumber() == random) {
                player.setWinner(true);
            }
        }
    }

    public void sendWinners(ArrayList<Player> list) {
        int count = 0;
        for (Player player : list) {
            if (player.checkWinner()) {
                System.out.println("The winner is " + player.getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no winners! :(");
        }
    }
}
