public class Human extends Player {
    public String getName () {
        return "Human";
    }

    public int takeTurn (int[][] board) {
        return KingOfTheHill.scanner.nextInt();
    }
}