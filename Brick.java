import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
class Brick extends JLabel {
    Color color[] = {Color.RED, Color.GREEN, Color.blue, Color.orange, Color.yellow};
    Random random = new Random();
    Position tr = null;
    Position tl = null;
    Position br = null;
    Position bl = null;
    private class Position{
        int x =0;
        int y = 0;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    Brick(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        setOpaque(true);
        setBackground(color[random.nextInt(5)]);
        tl = new Position(x, y);
        tr = new Position(x+width, y);
        bl = new Position(x, y+height);
        br = new Position(x+width, y+height);
    }
    public boolean overlap(Brick brick){
        return (check(brick.getX(), brick.getY()) || check(brick.getX()+brick.getWidth(), brick.getY()) || check(brick.getX(), brick.getY()+brick.getHeight()) || check(brick.getX()+brick.getWidth(), brick.getY()+brick.getHeight()));
    }
    private boolean check(int bx, int by){
        if(bx >= tl.x && bx <= tr.x && by >= tl.y && by <= bl.y){
            return true;
        }
        return false;
    }

}
