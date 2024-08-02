import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pieces {
    Image Be= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blackelephant.png").getImage();
    Image Bh= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blackghodo.png").getImage();
    Image Bb= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blackunat.png").getImage();
    Image Bq= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blackqueen.png").getImage();
    Image Bk= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blackking.png").getImage();
    Image Bs= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/blacksainik.png").getImage();
    Image We= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whiteelephant.png").getImage();
    Image Wh= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whiteghodo.png").getImage();
    Image Wb= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whiteunat.png").getImage();
    Image Wq= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whitequeen.png").getImage();
    Image Wk= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whiteking.png").getImage();
    Image Ws= new ImageIcon("C:/Users/anagh/Desktop/src/Asset/whitesainik.png").getImage();

    Image [][]Images = {{Be,Bh,Bb,Bq,Bk,Bs},{We,Wh,Wb,Wq,Wk,Ws}};
    int x;
    int y;
    int color;
    boolean Select =false;
    boolean first = true;
    int move =0;
    Image img;
    int image;

    Pieces(int x,int y,int color,int img)
    {
        this.x =x;
        this.y = y;
        this.color = color;
        image =img;
        this.img = Images[color][img];

    }
    public void Paint(Graphics g){}  /* Method Overriding */
    public void PaintMoves(Graphics g,Pieces[][]board){}
    public ArrayList<int[]> moves(Pieces[][]board){
        return new ArrayList<>();
    }
}


class Elephant extends Pieces
{
    Elephant(int x, int y, int color) {
        super(x, y, color,0);
    }
    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        int i = x-1;
        int j = y;
        while(i>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i--;
        }
        i = x+1;
        while(i<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i++;
        }
        i=x;
        j = y+1;
        while(j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j++;
        }
        j = y-1;
        while(j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j--;
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}

class Horse extends Pieces
{
    Horse(int x, int y, int color) {
        super(x, y, color, 1);
    }

    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        int [][] moves = {{x-2,y+1},{x-2,y-1},{x+2,y-1},{x+2,y+1},{x-1,y+2},{x-1,y-2},{x+1,y-2},{x+1,y+2}};
        for (int [] i:moves)
        {
            if (i[0] > -1 && i[0]<8 && i[1] > -1 && i[1]<8 ) {
                if(board[i[0]][i[1]] !=null)
                {
                    if (board[i[0]][i[1]].color !=this.color) {
                        {
                            move.add(i);
                        }
                    }
                }
                else
                    move.add(i);
            }
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}

class Bishop extends Pieces
{
    Bishop(int x, int y, int color) {
        super(x, y, color, 2);
    }

    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        int i = x-1;
        int j = y-1;
        while(i>=0 && j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i--;
            j--;
        }
        i = x+1;
        j=y+1;
        while(i<=7&& j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i++;
            j++;
        }
        i=x-1;
        j = y+1;
        while(i>=0&&j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j++;
            i--;
        }
        j = y-1;
        i =x+1;
        while(i<=7&&j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j--;
            i++;
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}

class Queen extends Pieces
{
    Queen(int x, int y, int color) {
        super(x, y, color, 3);
    }

    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        int i = x-1;
        int j = y-1;
        while(i>=0 && j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i--;
            j--;
        }
        i = x+1;
        j=y+1;
        while(i<=7&& j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i++;
            j++;
        }
        i=x-1;
        j = y+1;
        while(i>=0&&j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j++;
            i--;
        }
        j = y-1;
        i =x+1;
        while(i<=7&&j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j--;
            i++;
        }
        i = x-1;
        j=y;
        while(i>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i--;
        }
        i = x+1;
        while(i<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            i++;
        }
        i=x;
        j = y+1;
        while(j<=7){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j++;
        }
        j = y-1;
        while(j>=0){
            if(board[i][j] !=null){
                if (board[i][j].color !=this.color)
                    move.add(new int[]{i,j});
                break;
            }
            move.add(new int[]{i,j});
            j--;
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}

class King extends Pieces
{
    King(int x, int y, int color) {
        super(x, y, color, 4);
    }

    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        int [][] moves = {{x-1,y-1},{x-1,y},{x-1,y+1},{x,y-1},{x,y+1},{x+1,y-1},{x+1,y},{x+1,y+1}};
        for (int [] i:moves)
        {
            if (i[0] > -1 && i[0]<8 && i[1] > -1 && i[1]<8 ) {
                if(board[i[0]][i[1]] !=null)
                {
                    if (board[i[0]][i[1]].color !=this.color) {
                        {
                            move.add(i);
                        }
                    }
                }
                else
                    move.add(i);
            }
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}
class Soldier extends Pieces
{
    Soldier(int x, int y, int color) {
        super(x, y, color, 5);
        first = true;
        move =0;
    }

    @Override
    public void Paint(Graphics g)
    {
        g.drawImage(img,y*75+5,x*75+5,65,65,null);
    }
    public ArrayList<int[]> moves(Pieces[][]board)
    {
        ArrayList<int[]> move = new ArrayList<>();
        if(color ==0)
        {
            if (first && board[x+1][y] == null)
                if(x<6&& board[x+2][y] == null)
                    move.add(new int[]{x+2,y});

            if(x<7 && board[x+1][y] == null)
                move.add(new int[]{x+1,y});
            if(y<7)
                if(board[x+1][y+1]!=null && board[x+1][y+1].color !=this.color)
                    move.add(new int[]{x+1,y+1});
            if(y>0)
                if(board[x+1][y-1]!=null && board[x+1][y-1].color !=this.color)
                   move.add(new int[]{x+1,y-1});

        }
        else {
            if (first &&board[x-1][y] == null)
                if(x>1&&board[x-2][y] == null)
                    move.add(new int[]{x-2,y});

            if(x>0)
                if (board[x-1][y] == null)
                    move.add(new int[]{x-1,y});
            if(y>0)
                if(board[x-1][y-1]!=null && board[x-1][y-1].color !=this.color)
                    move.add(new int[]{x-1,y-1});
            if (y<7 && x>0)
                if(board[x-1][y+1]!=null && board[x-1][y+1].color !=this.color)

                    move.add(new int[]{x-1,y+1});
        }
        return move;
    }
    @Override
    public void PaintMoves(Graphics g,Pieces[][]board){
        ArrayList<int[]> move = moves(board);
        for(int[] i:move)
        {
            g.setColor(Color.blue);
            g.fillOval(i[1]*75+27,i[0]*75+27,20,20);
        }
    }
}