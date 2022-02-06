package chess;

public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return super.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7) {
            return false;
        }
        if (toColumn < 0 || toColumn > 7) {
            return false;
        }

        if ((toLine == line + 2) && ((toColumn == column + 1) || (toColumn == column - 1))) {
            return checkPathHorse(chessBoard, toLine, toColumn, color);
        } else  if ((toLine == line - 2) && ((toColumn == column + 1) || (toColumn == column - 1))) {
            return checkPathHorse(chessBoard, toLine, toColumn, color);
        } else if ((toColumn == column + 2) && ((toLine == line + 1) || (toLine == line - 1))) {
            return checkPathHorse(chessBoard, toLine, toColumn, color);
        } else if ((toColumn == column - 2) && ((toLine == line + 1) || (toLine == line - 1))) {
            return checkPathHorse(chessBoard, toLine, toColumn, color);
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "H";
    }
}
