import java.util.Scanner;

public class Player {
    private int number;
    private String name;
    private boolean isWinner;

    public void guess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Send your guess (0-99):");
        this.number = Integer.parseInt(scanner.nextLine());
        System.out.println("Send your name:");
        this.name = scanner.nextLine();
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkWinner() { return this.isWinner; }

    public void setWinner(boolean condition) {
        this.isWinner = condition;
    }
}
