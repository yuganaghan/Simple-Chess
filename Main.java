import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;


class JavaPanel extends JPanel
{
    Board board = new Board();
    JavaPanel()
    {
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);
        this.addMouseListener(new mouse());
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        board.paint(g);
        if(board.GameOver)
        {
            g.setFont(new Font("monospace",Font.BOLD,100));
            g.setColor(Color.red);
            g.drawString("GameOver",5,350);
        }
    }
    class mouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            int y = e.getX()/75;
            int x = e.getY()/75;
            if (!board.GameOver)
            {
                board.movePiece(x,y);
                board.select(x,y);
            }
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}



class JavaFrame extends JFrame
{
    JavaFrame()
    {
        this.add(new JavaPanel());
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

}
public class Main {
    public static void main(String[] args) {
        new JavaFrame();
    }
}