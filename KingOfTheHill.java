import java.util.Scanner;

public class KingOfTheHill {
    public static Scanner scanner = new Scanner(System.in);

    private static Alignment other (Alignment alignment) {
        if (alignment == Alignment.PLAYER_1)
            return Alignment.PLAYER_2;
        return Alignment.PLAYER_1;
    }

    private static String toString (Alignment alignment) {
        if (alignment == Alignment.UNALIGNED)
            return "Tie";
        if (alignment == Alignment.PLAYER_1)
            return "Player 1";
        return "Player 2";
    }

    private static Player whoseTurn (Alignment turn, Player player1, Player player2) {
        if (turn == Alignment.PLAYER_1)
            return player1;
        return player2;
    }

    public static void main (String [] args) {
        Player[] players = {new ShitUh(), new Left(), new NoStacks()};
        int[] wins = new int[players.length];

        for (int i = 0; i < players.length; i++)
            for (int j = 0; j < players.length; j++) {
                Board board = new Board();
                Player player1 = players[i];
                Player player2 = players[j];

                Alignment turn = Alignment.PLAYER_1;
                boolean idle = false;

                System.out.println(player1.getName() + " VS " + player2.getName());
                //System.out.println(board);

                while (true) {
                    int result = board.putAt(turn, whoseTurn(turn, player1, player2).takeTurn(board.toArray(turn)));
                    if (result == 1)
                        break;
                    else if (result == -1) {
                        if (idle) {
                            turn = Alignment.UNALIGNED;
                            break;
                        } else
                            idle = true;
                    }
                    else
                        idle = false;

                    //System.out.println(player1.getName() + " VS " + player2.getName());
                    //System.out.println(board);
                    turn = other(turn);
                }

                //System.out.println(player1.getName() + " VS " + player2.getName());
                //System.out.println(board);

                System.out.println("Winner: " + whoseTurn(turn, player1, player2).getName());
                System.out.println();
                if (player1 == whoseTurn(turn, player1, player2))
                    wins[i]++;
                else
                    wins[j]++;
            }

        System.out.println("Scoreboard:");
        for (int i = 0; i < players.length; i++)
            System.out.println(players[i].getName() + ": " + wins[i]);
    }
}