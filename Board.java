import java.awt.*;
import java.util.ArrayList;

public class Board {
    Pieces[][] board = new Pieces[8][8];
    boolean deselection = false;
    int Select = 1;
    int blackPiece = 16;
    int whitePiece = 16;
    int moves = 51;
    boolean GameOver = false;

    Board() {
        board[0][0] = new Elephant(0, 0, 0);
        board[0][1] = new Horse(0, 1, 0);
        board[0][2] = new Bishop(0, 2, 0);
        board[0][3] = new Queen(0, 3, 0);
        board[0][4] = new King(0, 4, 0);
        board[0][5] = new Bishop(0, 5, 0);
        board[0][6] = new Horse(0, 6, 0);
        board[0][7] = new Elephant(0, 7, 0);

        board[1][0] = new Soldier(1, 0, 0);
        board[1][1] = new Soldier(1, 1, 0);
        board[1][2] = new Soldier(1, 2, 0);
        board[1][3] = new Soldier(1, 3, 0);
        board[1][4] = new Soldier(1, 4, 0);
        board[1][5] = new Soldier(1, 5, 0);
        board[1][6] = new Soldier(1, 6, 0);
        board[1][7] = new Soldier(1, 7, 0);


        board[7][0] = new Elephant(7, 0, 1);
        board[7][1] = new Horse(7, 1, 1);
        board[7][2] = new Bishop(7, 2, 1);
        board[7][3] = new Queen(7, 3, 1);
        board[7][4] = new King(7, 4, 1);
        board[7][5] = new Bishop(7, 5, 1);
        board[7][6] = new Horse(7, 6, 1);
        board[7][7] = new Elephant(7, 7, 1);

        board[6][0] = new Soldier(6, 0, 1);
        board[6][1] = new Soldier(6, 1, 1);
        board[6][2] = new Soldier(6, 2, 1);
        board[6][3] = new Soldier(6, 3, 1);
        board[6][4] = new Soldier(6, 4, 1);
        board[6][5] = new Soldier(6, 5, 1);
        board[6][6] = new Soldier(6, 6, 1);
        board[6][7] = new Soldier(6, 7, 1);
    }

    public void paint(Graphics g) {
        drawBoard(g);
        DrawPieces(g);
        drawSelect(g);
    }

    public void drawBoard(Graphics g) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i + j) % 2 != 0)
                    g.setColor(new Color(73, 72, 72));
                else
                    g.setColor(new Color(210, 210, 210));
                g.fillRect(i * 75, j * 75, 75, 75);
            }
        }
    }

    public void DrawPieces(Graphics g) {
        for (Pieces[] i : board) {
            for (Pieces j : i) {
                if (j != null) {
                    j.Paint(g);
                }
            }
        }
    }

    public void select(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] != null) {
                    board[i][j].Select = false;
                }
            }
        }
        if (board[x][y] != null)
            if (!deselection)
                if (Select == board[x][y].color) {
                    board[x][y].Select = true;
                }
        deselection = false;

    }

    public void drawSelect(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].Select) {
                        g2.setStroke(new BasicStroke(3));
                        g.setColor(Color.red);
                        g.drawRect(j * 75, i * 75, 75, 75);
                        board[i][j].PaintMoves(g, board);
                    }
                }
            }
        }
    }

    public void movePiece(int a, int b) {
        Pieces change = null;
        int q = 0;
        int w = 0;
        if (moves == 0)
        {
            GameOver=true;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] != null) {
                    if (board[i][j].Select) {
                        change = board[i][j];
                        q = i;
                        w = j;
                    }
                }
            }
        }
        if (change != null) {
            ArrayList<int[]> move = change.moves(board);
            for (int[] c : move) {
                if (c[0] == a && c[1] == b) {
                    if (board[a][b] != null) {
                        if (board[a][b].color == 1) {
                            whitePiece--;
                        } else {
                            blackPiece--;
                        }
                        if (board[a][b].image == 4) {
                            GameOver = true;
                        }
                    }
                    if (change.image == 5) {
                        board[q][w].first = false;
                    }

                    board[a][b] = change;
                    board[a][b].x = a;
                    board[a][b].y = b;
                    board[q][w] = null;
                    deselection = true;
                    if(board[a][b].image==5)
                    {
                        if (board[a][b].color == 0)
                            if (board[a][b].x==7)
                                board[a][b] = new Queen(a,b,0);
                        if (board[a][b].color ==1)
                            if (board[a][b].x == 0)
                                board[a][b] = new Queen(a,b,1);
                    }
                    if (Select == 0) {
                        Select = 1;
                    } else {
                        Select = 0;
                    }

                    if(whitePiece ==1){moves--;}
                    else if(blackPiece ==1){moves--;}

                }
            }
        }
    }
}
