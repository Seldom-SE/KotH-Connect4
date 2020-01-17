public class Column {
    private Piece [] pieces;
    private int curr;

    public Column () {
        pieces = new Piece[8];
        for (int i = 0; i < 8; i++)
            pieces[i] = new Piece();
        curr = 0;
    }

    public Alignment getAlignmentAt (int at) {
        return pieces[at].getAlignment();
    }

    public boolean isAlignedAt (Alignment alignment, int at) {
        if (at < 0 || at >= 8)
            return false;
        return pieces[at].isAligned(alignment);
    }

    public int put (Alignment alignment) {
        if (curr < 8)
            pieces[curr].setAlignment(alignment);
        return curr++;
    }

    public String toString () {
        String string = "";
        for (Piece piece : pieces)
            string += piece.toString();
        return string;
    }
}