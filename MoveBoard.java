import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
class MoveBoard extends Thread{
    int n;
    MoveBoard(int n){
        this.n = n;
        start();

    }
    public void run() {
        if(n==KeyEvent.VK_LEFT && BrickBreaker.board.getX()>0)
            BrickBreaker.board.setBounds(BrickBreaker.board.getX()-20, BrickBreaker.board.getY(), BrickBreaker.board.getWidth(), BrickBreaker.board.getHeight());
        else if(n==KeyEvent.VK_RIGHT && BrickBreaker.board.getX()+ BrickBreaker.board.getWidth() < 980)
            BrickBreaker.board.setBounds(BrickBreaker.board.getX()+20, BrickBreaker.board.getY(), BrickBreaker.board.getWidth(), BrickBreaker.board.getHeight());
    }
}
