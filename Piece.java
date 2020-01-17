public class Piece {
    private Alignment alignment;

    public Piece () {
        alignment = Alignment.UNALIGNED;
    }

    public Alignment getAlignment () {
        return alignment;
    }

    public boolean isAligned (Alignment alignment) {
        return this.alignment == alignment;
    }

    public void setAlignment (Alignment alignment) {
        this.alignment = alignment;
    }

    public String toString () {
        switch (alignment) {
            case PLAYER_1:
                return "#";
            case PLAYER_2:
                return "O";
            default:
                return " ";
        }
    }
}