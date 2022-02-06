package chess;

public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
//        if ((toLine - line) > 0 && (toColumn - column) > 0) {
//        for (int i = 1; i <= (toLine - line); i++) {
//            if (chessBoard.board[line + i][column + i] != null && i != (toLine - line)) {
//                return false;
//            } else if (i == (toLine - line)) {
//                return true;
//            }
//        }

    public static boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, String color) {
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            return false;
        }
        if ((toLine - line) > 0 && (toColumn - column) > 0) {
            for (int i = 1; i <= (toLine - line); i++) {
                if (chessBoard.board[line + i][column + i] != null) {
                    return i == (toLine - line);
                } else if (i == (toLine - line)) {
                    return true;
                }
            }
        } else if ((toLine - line) < 0 && (toColumn - column) < 0) {
            for (int i = -1; i >= (toLine - line); i--) {
                if (chessBoard.board[line + i][column + i] != null) {
                    return i == (toLine - line);
                } else if (i == (toLine - line)) {
                    return true;
                }
            }
        } else if ((toLine - line) > 0 && (toColumn - column) < 0) {
            int counter = 0;
            for (int i = 1; i <= (toLine - line); i++) {
                counter -= 1;
                if (chessBoard.board[line + i][column + counter] != null) {
                    return i == (toLine - line);
                } else if (i == (toLine - line)) {
                    return true;
                }
            }
        } else if ((toLine - line) < 0 && (toColumn - column) > 0) {
            int counter = 0;
            for (int i = 1; i <= (toColumn - column); i++) {
                counter -= 1;
                if (chessBoard.board[line + counter][column + i] != null) {
                    return i == (toColumn - column);
                } else if (i == (toColumn - column)) {
                    return true;
                }
            }
        } else if ((toLine - line) > 0 && (toColumn - column) == 0) {
            for (int i = 1; i <= (toLine - line); i++) {
                if (chessBoard.board[line + i][column] != null) {
                    return i == (toLine - line);
                } else if (i == (toLine - line)) {
                    return true;
                }
            }
        } else if ((toLine - line) < 0 && (toColumn - column) == 0) {
            for (int i = -1; i >= (toLine - line); i--) {
                if (chessBoard.board[line + i][column] != null) {
                    return i == (toLine - line);
                } else if (i == (toLine - line)) {
                    return true;
                }
            }
        } else if ((toLine - line) == 0 && (toColumn - column) > 0) {
            for (int i = 1; i <= (toColumn - column); i++) {
                if (chessBoard.board[line][column + i] != null) {
                    return i == (toColumn - column);
                } else if (i == (toColumn - column)) {
                    return true;
                }
            }
        } else if ((toLine - line) == 0 && (toColumn - column) < 0) {
            for (int i = -1; i >= (toColumn - column); i--) {
                if (chessBoard.board[line][column + i] != null) {
                    return i == (toColumn - column);
                } else if (i == (toColumn - column)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkPathHorse(ChessBoard chessBoard, int toLine, int toColumn, String color) {
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color)) {
            return false;
        } else {
            return true;
        }
    }


}
