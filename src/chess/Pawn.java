package chess;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
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
        if (super.color.equals("White") && (toLine == line + 1) && (toColumn == column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if (super.color.equals("Black") && (toLine == line - 1) && (toColumn == column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if (super.color.equals("White") && (toLine == line + 2) && (toColumn == column) && (line == 1)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if (super.color.equals("Black") && (toLine == line - 2) && (toColumn == column) && (line == 6)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "P";
    }
}
