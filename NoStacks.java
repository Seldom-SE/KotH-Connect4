public class NoStacks extends Player {
    public String getName () {
        return "No Stacks";
    }

    public int takeTurn (int[][] board) {
        for (int i = 0; i < 8; i++)
            if (board[5][i] == -1 && board[4][i] == 0)
                return i;
        return 1;
    }
}