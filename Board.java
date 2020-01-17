public class Board {
    private Column[] board;

    public Board () {
        board = new Column[8];
        for (int i = 0; i < 8; i++)
            board[i] = new Column();
    }

    public int putAt (Alignment alignment, int column) {
        if (column < 0 || column >= 8)
            return -1;
        int row = board[column].put(alignment);
        if (row > 8)
            return -1;
        
        if ((isAlignedAt(alignment, row - 1, column - 1) && isAlignedAt(alignment, row - 2, column - 2) && isAlignedAt(alignment, row - 3, column - 3))
         || (isAlignedAt(alignment, row - 1, column)     && isAlignedAt(alignment, row - 2, column)     && isAlignedAt(alignment, row - 3, column))
         || (isAlignedAt(alignment, row - 1, column + 1) && isAlignedAt(alignment, row - 2, column + 2) && isAlignedAt(alignment, row - 3, column + 3))
         || (isAlignedAt(alignment, row,     column - 1) && isAlignedAt(alignment, row,     column - 2) && isAlignedAt(alignment, row,     column - 3))
         || (isAlignedAt(alignment, row,     column + 1) && isAlignedAt(alignment, row,     column + 2) && isAlignedAt(alignment, row,     column + 3))
         || (isAlignedAt(alignment, row + 1, column - 1) && isAlignedAt(alignment, row + 2, column - 2) && isAlignedAt(alignment, row + 3, column - 3))
         || (isAlignedAt(alignment, row + 1, column + 1) && isAlignedAt(alignment, row + 2, column + 2) && isAlignedAt(alignment, row + 3, column + 3)))
            return 1;

        return 0;
    }

    public boolean isAlignedAt (Alignment alignment, int row, int column) {
        if (column < 0 || column >= 8)
            return false;
        return board[column].isAlignedAt(alignment, row);
    }

    public String toString () {
        String [] rowStrings = new String [8];
        for (int i = 0; i < 8; i++)
            rowStrings[i] = "";
        
        String [] columnStrings = new String [8];
        for (int i = 0; i < 8; i++)
            columnStrings[i] = board[i].toString();
        
        String string = "";
        for (int i = 7; i >= 0; i--) {
            string += '|';
            for (int j = 0; j < 8; j++)
                string += columnStrings[j].charAt(i) + " ";
            string += "|\n";
        }
        return string;
    }

    public int[][] toArray (Alignment alignment) {
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Alignment pieceAlignment = this.board[i].getAlignmentAt(7 - j);
                if (pieceAlignment == Alignment.UNALIGNED)
                    board[j][i] = 0;
                else if (pieceAlignment == alignment)
                    board[j][i] = 1;
                else
                    board[j][i] = -1;
            }
        return board;
    }
}