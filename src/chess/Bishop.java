package chess;

public class Bishop extends ChessPiece{
    public Bishop(String color) {
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

        if ((line - toLine == 0) || (column - toColumn == 0)) {
            return false;
        }

        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "B";
    }
}
