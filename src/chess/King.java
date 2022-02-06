package chess;

public class King extends ChessPiece{
    public King(String color) {
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


        if ((line - toLine == 0) && (column - toColumn == Math.abs(1))) {
            check = false;
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if ((line - toLine == Math.abs(1)) && (column - toColumn == 0)) {
            check = false;
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else if ((line - toLine == Math.abs(1)) && (column - toColumn == Math.abs(1))){
            check = false;
            return checkPath(chessBoard, line, column, toLine, toColumn, getColor());
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((board.board[i][j] != null) && !(board.board[i][j].getColor().equals(this.color)) &&
                        board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

}
