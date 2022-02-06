package chess;

public class Rook extends ChessPiece{
    public Rook(String color) {
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


        if ((line - toLine == 0) && (Math.abs(column - toColumn) >= 1)) {
            check = false;
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if ((Math.abs(line - toLine) >= 1) && (column - toColumn == 0)) {
            check = false;
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "R";
    }
}
