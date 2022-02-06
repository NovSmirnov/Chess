package chess;

public class Queen extends ChessPiece{
    public Queen(String color) {
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
        if ((line - toLine == 0) && (column - toColumn == 0)) {
            return false;
        }

        if ((line - toLine == 0) && (Math.abs(column - toColumn) >= 1)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        }
        if ((Math.abs(line - toLine) >= 1) && (column - toColumn == 0)){
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        }
        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "Q";
    }

}
